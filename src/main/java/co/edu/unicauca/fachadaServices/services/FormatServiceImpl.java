package co.edu.unicauca.fachadaServices.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
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
    public FormatDTO createFormat(FormatDTO format) {
        FormatEntity formatEntity = this.mapper.toFormatEntity(format);
        formatEntity.setState("formulated");
        formatEntity.setDate(new Date());
        return this.mapper.toFormatDTO(repository.save(formatEntity));
    }

    @Override
    public FormatDTO updateFormat(Integer id, FormatDTO format) {
        return null;
    }

    @Override
    public FormatDTO getFormat(Integer id) {
        return null;
    }

    @Override
    public void deleteFormat(Integer id) {
        repository.delete(id);
    }

    @Override
    public FormatDTO findAllFormatDTO() {
        return null;
    }

    @Override
    public String changeState(Integer id, String state) {
        Optional<FormatEntity> format = repository.findById(id);

        Result result = null;
        
        if(format.isPresent()){

            FormatDTO formatDTO = this.mapper.toFormatDTO(format.get());

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
