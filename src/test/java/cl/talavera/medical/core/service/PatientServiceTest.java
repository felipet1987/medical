package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.PatientDto;
import cl.talavera.medical.adapter.repository.PatientDaoRepository;
import cl.talavera.medical.adapter.repository.dao.PatientDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PatientServiceTest {
    private PatientDaoRepository patientRepostory;
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        patientRepostory = mock(PatientDaoRepository.class);
        patientService = new PatientService(patientRepostory);
    }

    @Test
    void getAllPatients() {
        PatientDao patientDao = new PatientDao();
        patientDao.setAge(25);
        List<PatientDao> patientsDao = List.of(patientDao);

        given(patientRepostory.findAll()).willReturn(patientsDao);

        PatientDto patientDto = new PatientDto();
        patientDto.setAge(25);
        List<PatientDto> expected = List.of(patientDto);

        List<PatientDto> patients = patientService.getAllPatients();

        assertEquals(expected, patients);
    }

    @Test
    void getPatientById() {
    }

    @Test
    void deletePatient() {
    }

    @Test
    void updatePatient() {
    }

    @Test
    void createPatient() {
    }
}