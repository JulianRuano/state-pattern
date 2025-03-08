package co.edu.unicauca.capaControladores;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/format/{id}")
    public FormatDTOResponse updateFormat(@PathVariable Integer id, @RequestBody FormatDTORequest format) {
        return formatService.updateFormat(id, format);
    }

    @GetMapping("/format/{id}")
    public FormatDTOResponse getFormat(@PathVariable Integer id) {
        return formatService.getFormat(id);
    }

    @GetMapping("/format/{startDate}/{endDate}")
    public Collection<FormatDTOResponse> getFormatsByDateRange(@PathVariable String startDate,@PathVariable String endDate) {
        return formatService.getFormatByDateRange(startDate, endDate);
    }

}
