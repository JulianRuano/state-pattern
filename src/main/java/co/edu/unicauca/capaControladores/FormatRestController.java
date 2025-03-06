package co.edu.unicauca.capaControladores;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import co.edu.unicauca.fachadaServices.services.IFormatService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FormatRestController {

    @Qualifier("formatServiceImpl")
    private final IFormatService formatService;

    @PostMapping("/format")
    public FormatDTO createFormat(@RequestBody FormatDTO format) {
        return formatService.createFormat(format);
    }
    
    
}
