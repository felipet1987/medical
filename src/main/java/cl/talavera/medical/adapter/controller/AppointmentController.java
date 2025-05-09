package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.adapter.controller.dto.AppointmentDto;
import cl.talavera.medical.core.port.AppointmentServicePort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class AppointmentController {

    private final AppointmentServicePort appointmentService;

    public AppointmentController(AppointmentServicePort appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointmentById(@PathVariable long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public AppointmentDto createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.createAppointment(appointmentDto);
    }

    @PutMapping("/{id}")
    public AppointmentDto updateAppointment(@PathVariable long id, @RequestBody AppointmentDto appointmentDto) {
        return appointmentService.updateAppointment(id, appointmentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
    }
}
