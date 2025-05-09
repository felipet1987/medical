package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.core.port.SpecialtyServicePort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class SpecialtyController {

    private final SpecialtyServicePort specialtyService;

    public SpecialtyController(SpecialtyServicePort specialtyService) {
        this.specialtyService = specialtyService;
    }



    @GetMapping
    public List<?> getAllSpecialties() {
        // TODO: Implement logic
        return null;
    }

    @PostMapping
    public Object createSpecialty(@RequestBody Object specialtyDto) {
        // TODO: Implement logic
        return null;
    }
}
