package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.PatientDto;
import cl.talavera.medical.adapter.repository.PatientDaoRepository;
import cl.talavera.medical.adapter.repository.dao.PatientDao;
import cl.talavera.medical.mapper.PatientMapper;
import org.springframework.stereotype.Service;
import cl.talavera.medical.core.port.PatientServicePort;

import java.util.List;

@Service
public class PatientService implements PatientServicePort {
    private final PatientDaoRepository patientRepostory;

    public PatientService(PatientDaoRepository patientRepostory) {
        this.patientRepostory = patientRepostory;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientDao> patients = patientRepostory.findAll();


        return patients.stream().map(PatientMapper::toDto).toList();
    }

    @Override
    public PatientDto getPatientById(Long id) {
        return null;
    }

    @Override
    public boolean deletePatient(Long id) {
        return false;
    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDetails) {
        return null;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        return null;
    }

}
