package co.edu.unicauca.fachadaServices.services;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;
import co.edu.unicauca.fachadaServices.DTO.response.FormatDTOResponse;
import co.edu.unicauca.fachadaServices.DTO.response.ResponseDto;
import co.edu.unicauca.fachadaServices.mapper.FormatMapper;
import co.edu.unicauca.fachadaServices.states.ApproveState;
import co.edu.unicauca.fachadaServices.states.CorrectionState;
import co.edu.unicauca.fachadaServices.states.EvaluationState;
import co.edu.unicauca.fachadaServices.states.FormulatedState;
import co.edu.unicauca.fachadaServices.states.RejectSatate;
import co.edu.unicauca.fachadaServices.states.Result;

@Service("formatServiceImpl")
public class FormatServiceImpl implements IFormatService {

    private StateServices stateServices;

    private FormatRepository repository;

    private final FormatMapper mapper;

    public FormatServiceImpl(FormatRepository repository, FormatMapper mapper, StateServices stateServices) {
        this.repository = repository;
        this.mapper = mapper;
        this.stateServices = stateServices;
    }

    @Override
    public ResponseDto<FormatDTOResponse> createFormat(FormatDTORequest format) {
        FormatEntity formatEntity = this.mapper.toFormatEntity(format);
        formatEntity.setState("formulated");
        formatEntity.setDate(new Date());
        return  new ResponseDto<>(this.mapper.toFormatDTOResponse(repository.save(formatEntity)), 201, "Formato creado correctamente");
    }

    @Override
    public ResponseDto<FormatDTOResponse> updateFormat(Integer id, FormatDTORequest format) {
        Optional<FormatEntity> existingFormatOpt = repository.findById(id);

        if (!existingFormatOpt.isPresent()) {
            return new ResponseDto<>(null, 404, "Formato no encontrado");
        }
        if (!existingFormatOpt.get().getState().equals("correction")) {
            return new ResponseDto<>(null, 400, "Formato no se encuentra en estado de corrección");
        }

        FormatEntity existingFormat = existingFormatOpt.get();
        FormatEntity updatedFormat = mapper.toFormatEntity(format);

        updatedFormat.setId(existingFormat.getId());
        updatedFormat.setState(existingFormat.getState());
        updatedFormat.setDate(existingFormat.getDate());

        FormatEntity savedFormat = repository.update(updatedFormat);
        return new ResponseDto<>(mapper.toFormatDTOResponse(savedFormat), 200, "Formato actualizado correctamente");
    }

    @Override
    public ResponseDto<FormatDTOResponse> getFormat(Integer id) {
        Optional<FormatEntity> format = repository.findById(id);
        if (format.isPresent()) {
            return new ResponseDto<>(mapper.toFormatDTOResponse(format.get()), 200, "Formato encontrado");
        }
        return null;
    }

    @Override
    public void deleteFormat(Integer id) {
        repository.delete(id);
    }

    @Override
    public ResponseDto<Collection<FormatDTOResponse>> getFormatByDateRange(String startDateStr, String endDateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);

            Collection<FormatEntity> formats = repository.findByDateRange(startDate, endDate);

            return new ResponseDto<>(formats.stream().map(mapper::toFormatDTOResponse).collect(Collectors.toList()), 200, "Formatos encontrados");
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use yyyy-MM-dd", e);
        }
    }

    @Override
    public ResponseDto<String> changeState(Integer id, String state) {
        Optional<FormatEntity> format = repository.findById(id);

        Result result = null;

        if (format.isPresent()) {

            FormatDTORequest formatDTO = this.mapper.toFormatDTORequest(format.get());
            this.assignState(format.get().getState());

            switch (state) {
                case "approved":
                    result = stateServices.approveFormat(formatDTO);
                    break;
                case "rejected":
                    result = stateServices.rejectFormat(formatDTO);
                    break;
                case "correction":
                    result = stateServices.sendForCorrection(formatDTO);
                    break;
                case "evaluation":
                    result = stateServices.sendForEvaluation(formatDTO);
                    break;
            }
        }

        return new ResponseDto<>(result.message(), 200, "Estado actualizado correctamente");  
    }

    private void assignState(String currentState) {
        switch (currentState) {
            case "formulated":
                stateServices.setState(new FormulatedState(repository));
                break;
            case "approved":
                stateServices.setState(new ApproveState());
                break;
            case "rejected":
                stateServices.setState(new RejectSatate());
                break;
            case "correction":
                stateServices.setState(new CorrectionState(repository));
                break;
            case "evaluation":
                stateServices.setState(new EvaluationState(repository));
                break;
        }
    }
    
}
