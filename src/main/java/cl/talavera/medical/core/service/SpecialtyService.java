package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.SpecialtyDto;
import cl.talavera.medical.adapter.repository.SpecialtyDaoRepository;
import cl.talavera.medical.core.port.SpecialtyServicePort;
import cl.talavera.medical.mapper.SpecialtyMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpecialtyService implements SpecialtyServicePort {
    private final SpecialtyDaoRepository specialtyRepository;

    public SpecialtyService(SpecialtyDaoRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public List<SpecialtyDto> getAllSpecialties() {
        return specialtyRepository.findAll().stream()
                .map(SpecialtyMapper::toDto)
                .toList();
    }
    // Add other methods as needed
}
