package cl.talavera.medical.core.port;

import cl.talavera.medical.adapter.controller.dto.AppointmentDto;

import java.util.List;

public interface AppointmentServicePort {
    List<AppointmentDto> getAllAppointments();
    AppointmentDto getAppointmentById(long id);
    AppointmentDto createAppointment(AppointmentDto toCreate);
    AppointmentDto updateAppointment(long id, AppointmentDto updateRequest);
    void deleteAppointment(long id);
}
