package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.adapter.controller.dto.DoctorDto;
import cl.talavera.medical.core.port.DoctorServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DoctorController.class)
class DoctorControllerTest {
    private DoctorController doctorController;
    private DoctorServicePort doctorService;


    @BeforeEach
    void setUp() {
        doctorService = mock(DoctorServicePort.class);
        doctorController = new DoctorController(doctorService);
    }


    @Test
    void getAllDoctors() {
        List<DoctorDto> expected = List.of(
                DoctorDto.builder()
                        .id(1L)
                        .name("Dr. Smith")
                        .licenseNumber("LIC123")
                        .specialty("Cardiology")
                        .build()
        );
        given(doctorService.getAllDoctors()).willReturn(expected);
        List<DoctorDto> actual = doctorController.getAllDoctors();
        assertEquals(expected, actual);
    }
}
