package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.adapter.controller.dto.SpecialtyDto;
import cl.talavera.medical.core.port.SpecialtyServicePort;
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

@WebMvcTest(SpecialtyController.class)
class SpecialtyControllerTest {
    private SpecialtyController specialtyController;
    private SpecialtyServicePort specialtyService;


    @BeforeEach
    void setUp() {
        specialtyService = mock(SpecialtyServicePort.class);
        specialtyController = new SpecialtyController(specialtyService);
    }




}
