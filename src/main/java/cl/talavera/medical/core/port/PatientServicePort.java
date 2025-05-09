package cl.talavera.medical.core.port;

import cl.talavera.medical.adapter.controller.dto.PatientDto;
import cl.talavera.medical.adapter.repository.dao.PatientDao;

import java.util.List;

public interface PatientServicePort {
    List<PatientDto> getAllPatients();

    PatientDto getPatientById(Long id);

    boolean deletePatient(Long id);

    PatientDto updatePatient(Long id, PatientDto patientDetails);

    PatientDto createPatient(PatientDto patientDto);
}
