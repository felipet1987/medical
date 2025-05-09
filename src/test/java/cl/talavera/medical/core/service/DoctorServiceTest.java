package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.DoctorDto;
import cl.talavera.medical.adapter.repository.DoctorDaoRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {
    private DoctorDaoRepository doctorRepository;
    private final DoctorService doctorService = new DoctorService(doctorRepository);

    @Test
    void getAllDoctorsReturnsEmptyList() {
        List<DoctorDto> result = doctorService.getAllDoctors();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
