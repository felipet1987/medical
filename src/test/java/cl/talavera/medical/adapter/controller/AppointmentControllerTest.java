package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.adapter.controller.dto.AppointmentDto;
import cl.talavera.medical.core.port.AppointmentServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AppointmentControllerTest {
    private AppointmentController appointmentController;
    private AppointmentServicePort appointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = mock(AppointmentServicePort.class);
        appointmentController = new AppointmentController(appointmentService);
    }

    @Test
    void getAllAppointments() {
        LocalDateTime fixedDate = LocalDateTime.of(2025, 5, 8, 20, 16, 8, 830374000);
        List<AppointmentDto> expected = List.of(
                AppointmentDto.builder()
                        .id(1L)
                        .patientId(1L)
                        .doctorId(2L)
                        .appointmentDate(fixedDate)
                        .reason("Routine checkup")
                        .build()
        );
        given(appointmentService.getAllAppointments()).willReturn(expected);
        List<AppointmentDto> actual = appointmentController.getAllAppointments();
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + actual);
        assertEquals(expected, actual);
    }

    @Test
    void getAppointmentById() {
        LocalDateTime fixedDate = LocalDateTime.of(2025, 5, 8, 20, 16, 8, 830374000);
        AppointmentDto expected = AppointmentDto.builder()
                .id(1L)
                .patientId(1L)
                .doctorId(2L)
                .appointmentDate(fixedDate)
                .reason("Routine checkup")
                .build();
        given(appointmentService.getAppointmentById(1L)).willReturn(expected);
        AppointmentDto actual = appointmentController.getAppointmentById(1L);
        assertEquals(expected, actual);
    }

    @Test
    void createAppointment() {
        LocalDateTime fixedDate = LocalDateTime.of(2025, 5, 8, 20, 16, 8, 830374000);
        AppointmentDto toCreate = AppointmentDto.builder()
                .patientId(1L)
                .doctorId(2L)
                .appointmentDate(fixedDate)
                .reason("Routine checkup")
                .build();
        AppointmentDto created = AppointmentDto.builder()
                .id(1L)
                .patientId(1L)
                .doctorId(2L)
                .appointmentDate(fixedDate)
                .reason("Routine checkup")
                .build();
        given(appointmentService.createAppointment(toCreate)).willReturn(created);
        AppointmentDto actual = appointmentController.createAppointment(toCreate);
        assertEquals(created, actual);
    }

    @Test
    void updateAppointment() {
        LocalDateTime fixedDate = LocalDateTime.of(2025, 5, 8, 20, 16, 8, 830374000);
        AppointmentDto updateRequest = AppointmentDto.builder()
                .id(1L)
                .patientId(1L)
                .doctorId(2L)
                .appointmentDate(fixedDate)
                .reason("Updated reason")
                .build();
        AppointmentDto updated = AppointmentDto.builder()
                .id(1L)
                .patientId(1L)
                .doctorId(2L)
                .appointmentDate(fixedDate)
                .reason("Updated reason")
                .build();
        given(appointmentService.updateAppointment(1L, updateRequest)).willReturn(updated);
        Object actual = appointmentController.updateAppointment(1L, updateRequest);
        assertEquals(updated, actual);
    }

    @Test
    void deleteAppointment() {
        appointmentController.deleteAppointment(1L);
        verify(appointmentService).deleteAppointment(1L);
    }
}