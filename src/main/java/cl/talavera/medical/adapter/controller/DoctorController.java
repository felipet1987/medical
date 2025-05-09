package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.adapter.controller.dto.DoctorDto;
import cl.talavera.medical.core.port.DoctorServicePort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    private final DoctorServicePort doctorService;

    public DoctorController(DoctorServicePort doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors() {
        // TODO: Implement logic
        return null;
    }

    @GetMapping("/{id}")
    public Object getDoctorById(@PathVariable Long id) {
        // TODO: Implement logic
        return null;
    }

    @PostMapping
    public Object createDoctor(@RequestBody Object doctorDto) {
        // TODO: Implement logic
        return null;
    }

    @PutMapping("/{id}")
    public Object updateDoctor(@PathVariable Long id, @RequestBody Object doctorDto) {
        // TODO: Implement logic
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        // TODO: Implement logic
    }
}
