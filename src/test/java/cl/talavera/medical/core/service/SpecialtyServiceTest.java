package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.SpecialtyDto;
import cl.talavera.medical.adapter.repository.SpecialtyDaoRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SpecialtyServiceTest {
    private SpecialtyDaoRepository specialtyRepository;
    private final SpecialtyService specialtyService = new SpecialtyService(specialtyRepository);

    @Test
    void getAllSpecialtiesReturnsEmptyList() {
        List<SpecialtyDto> result = specialtyService.getAllSpecialties();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
