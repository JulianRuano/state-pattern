package co.edu.unicauca.fachadaServices.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;
import co.edu.unicauca.fachadaServices.DTO.response.FormatDTOResponse;
import co.edu.unicauca.fachadaServices.mapper.FormatMapper;
import co.edu.unicauca.fachadaServices.states.ApproveState;
import co.edu.unicauca.fachadaServices.states.CorrectionState;
import co.edu.unicauca.fachadaServices.states.EvaluationState;
import co.edu.unicauca.fachadaServices.states.FormulatedState;
import co.edu.unicauca.fachadaServices.states.RejectSatate;
import co.edu.unicauca.fachadaServices.states.Result;

@Service("formatServiceImpl")
public class FormatServiceImpl  implements IFormatService{

    private StateServices stateServices;

    private  FormatRepository repository;

    private final FormatMapper mapper;

    public FormatServiceImpl(FormatRepository repository, FormatMapper mapper, StateServices stateServices) {
        this.repository = repository;
        this.mapper = mapper;
        this.stateServices = stateServices;
    }

    @Override
    public FormatDTOResponse createFormat(FormatDTORequest format) {
        FormatEntity formatEntity = this.mapper.toFormatEntity(format);
        formatEntity.setState("formulated");
        formatEntity.setDate(new Date());
        return this.mapper.toFormatDTOResponse(repository.save(formatEntity));     
    }

    @Override
    public FormatDTOResponse updateFormat(Integer id, FormatDTORequest format) {
        return null;
    }

    @Override
    public FormatDTOResponse getFormat(Integer id) {
        Optional<FormatEntity> format = repository.findById(id);
        if(format.isPresent()){
            return this.mapper.toFormatDTOResponse(format.get());
        }
        return null;
    }

    @Override
    public void deleteFormat(Integer id) {
        repository.delete(id);
    }

    @Override
    public FormatDTOResponse findAllFormatDTO() {
        return null;
    }

    @Override
    public String changeState(Integer id, String state) {
        Optional<FormatEntity> format = repository.findById(id);

        Result result = null;
        
        if(format.isPresent()){

            FormatDTORequest formatDTO = this.mapper.toFormatDTORequest(format.get());

            //asignar un obj de estado al DTO
            switch (format.get().getState()) {
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

        return result.message();
        
    }
    
}
