package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.adapter.controller.dto.PatientDto;
import cl.talavera.medical.core.port.PatientServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PatientControllerTest {
    private PatientController patientController;
    private PatientServicePort patientService;

    @BeforeEach
    void setUp() {

         patientService = mock(PatientServicePort.class);
        patientController = new PatientController(patientService);
    }

    @Test
    void getAllPatients() {

        List<PatientDto> expected = List.of(
                PatientDto.builder()
                        .id(1L)
                        .firstName("John")
                        .lastName("Doe")
                        .age(25)
                        .gender("Male")
                        .email("john.doe@example.com")
                        .phone("1234567890")
                        .build()
        );
        given(patientService.getAllPatients()).willReturn(expected);


        List<PatientDto> actual = patientController.getAllPatients();


        assertEquals(expected, actual);

    }

    @Test
    void getPatientById() {
    }

    @Test
    void createPatient() {
    }

    @Test
    void updatePatient() {
    }

    @Test
    void deletePatient() {
    }
}