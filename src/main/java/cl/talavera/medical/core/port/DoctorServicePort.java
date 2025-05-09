package cl.talavera.medical.core.port;

import cl.talavera.medical.adapter.controller.dto.DoctorDto;

import java.util.List;

public interface DoctorServicePort {
    List<DoctorDto> getAllDoctors();
}
