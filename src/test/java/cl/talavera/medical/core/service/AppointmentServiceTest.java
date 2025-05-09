package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.AppointmentDto;
import cl.talavera.medical.adapter.repository.AppointmentDaoRepository;
import cl.talavera.medical.adapter.repository.dao.AppointmentDao;
import cl.talavera.medical.adapter.repository.dao.DoctorDao;
import cl.talavera.medical.adapter.repository.dao.PatientDao;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AppointmentServiceTest {
    private AppointmentDaoRepository appointmentRepository;
    private final AppointmentService appointmentService = new AppointmentService(appointmentRepository);

    @Test
    void getAllAppointments() {
        AppointmentDaoRepository appointmentRepository = mock(AppointmentDaoRepository.class);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);
        LocalDateTime now = LocalDateTime.now();

        AppointmentDao dao = new AppointmentDao();
        dao.setId(1L);
        dao.setDateTime(now);
        dao.setReason("test");
        PatientDao patient = new PatientDao();
        patient.setId(1L);
        dao.setPatient(patient);
        DoctorDao doctor = new DoctorDao();
        doctor.setId(1L);
        dao.setDoctor(doctor);

        List<AppointmentDao> daoList = List.of(dao);
        given(appointmentRepository.findAll()).willReturn(daoList);

        List<AppointmentDto> expected = List.of(AppointmentDto.builder()
                .id(1L)
                .patientId(1L)
                .doctorId(1L)
                .appointmentDate(now)
                .reason("test")
                .build());

        List<AppointmentDto> actual = appointmentService.getAllAppointments();

        assertEquals(expected, actual);
    }

    @Test
    void getAppointmentById() {
        AppointmentDaoRepository appointmentRepository = mock(AppointmentDaoRepository.class);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);
        LocalDateTime now = LocalDateTime.now();

        AppointmentDao dao = new AppointmentDao();
        dao.setId(1L);
        dao.setDateTime(now);
        dao.setReason("test");
        PatientDao patient = new PatientDao();
        patient.setId(1L);
        dao.setPatient(patient);
        DoctorDao doctor = new DoctorDao();
        doctor.setId(1L);
        dao.setDoctor(doctor);

        given(appointmentRepository.findById(1L)).willReturn(Optional.of(dao));

        AppointmentDto expected = AppointmentDto.builder()
                .id(1L)
                .patientId(1L)
                .doctorId(1L)
                .appointmentDate(now)
                .reason("test")
                .build();

        AppointmentDto actual = appointmentService.getAppointmentById(1L);

        assertEquals(expected, actual);
    }
}
