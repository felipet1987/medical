package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.DoctorDto;
import cl.talavera.medical.adapter.repository.DoctorDaoRepository;
import cl.talavera.medical.adapter.repository.dao.DoctorDao;
import cl.talavera.medical.core.port.DoctorServicePort;
import cl.talavera.medical.mapper.DoctorMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService implements DoctorServicePort {
    private final DoctorDaoRepository doctorRepository;

    public DoctorService(DoctorDaoRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(DoctorMapper::toDto)
                .toList();
    }
    // Add other methods as needed
}
