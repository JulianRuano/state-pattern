package co.edu.unicauca.fachadaServices.services;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import co.edu.unicauca.fachadaServices.states.Result;
import lombok.RequiredArgsConstructor;

@Service("formatServiceImpl")
public class FormatServiceImpl  implements IFormatService{

    private StateServices stateServices;

    @Qualifier("IDFormatoRepository")
    private  FormatRepository repository;

    private  ModelMapper modelMapper;

    public FormatServiceImpl(FormatRepository repository, ModelMapper modelMapper, StateServices stateServices) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.stateServices = stateServices;
    }

    @Override
    public FormatDTO createFormat(FormatDTO format) {
        FormatEntity formatEntity = this.modelMapper.map(format, FormatEntity.class);
        formatEntity.setState("formulado");
        formatEntity.setDate(new Date());
        return this.modelMapper.map(repository.save(formatEntity), FormatDTO.class);
    }

    @Override
    public FormatDTO updateFormat(Integer id, FormatDTO format) {
        return null;
    }

    @Override
    public FormatDTO getFormat(Integer id) {
        Optional<FormatEntity> format = repository.findById(id);
        return format.isPresent() ? this.modelMapper.map(format.get(), FormatDTO.class) : null;
    }

    @Override
    public void deleteFormat(Integer id) {
        repository.delete(id);
    }

    @Override
    public FormatDTO findAllFormatDTO() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllFormatDTO'");
    }

    @Override
    public String changeState(Integer id, String state) {
        Optional<FormatEntity> format = repository.findById(id);

        Result result = null;
        
        if(format.isPresent()){

            FormatDTO formatDTO = this.modelMapper.map(format.get(), FormatDTO.class);

            switch (state) {
                case "approved":
                    result = stateServices.approveFormat(formatDTO);
                case "rejected":
                    result = stateServices.rejectFormat(formatDTO);
                case "correction":
                    result = stateServices.sendForCorrection(formatDTO);
                case "evaluation":
                    result = stateServices.sendForEvaluation(formatDTO);     
                default:
                    break;
            }
        }

        return result.message();
        
    }
    
}
