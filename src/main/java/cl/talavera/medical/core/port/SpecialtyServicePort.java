package cl.talavera.medical.core.port;

import cl.talavera.medical.adapter.controller.dto.SpecialtyDto;

import java.util.List;

public interface SpecialtyServicePort {
    List<SpecialtyDto> getAllSpecialties();
}
