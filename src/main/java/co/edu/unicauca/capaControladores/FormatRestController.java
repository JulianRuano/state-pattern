package co.edu.unicauca.capaControladores;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;
import co.edu.unicauca.fachadaServices.DTO.response.FormatDTOResponse;
import co.edu.unicauca.fachadaServices.services.IFormatService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FormatRestController {

    @Qualifier("formatServiceImpl")
    private final IFormatService formatService;


    @PostMapping("/format")
    public FormatDTOResponse create(@RequestBody FormatDTORequest format) {    
        return formatService.createFormat(format);
    }
    
    @PatchMapping("/format/{id}/{state}")
    public String changeState(@PathVariable Integer id, @PathVariable String state) {
        return formatService.changeState(id, state);
    }

    @GetMapping("/format/{id}")
    public FormatDTOResponse getFormat(@PathVariable Integer id) {
        return formatService.getFormat(id);
    }
    
}
