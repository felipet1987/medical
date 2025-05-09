package cl.talavera.medical.core.service;

import cl.talavera.medical.adapter.controller.dto.AppointmentDto;
import cl.talavera.medical.adapter.repository.AppointmentDaoRepository;
import cl.talavera.medical.adapter.repository.dao.DoctorDao;
import cl.talavera.medical.adapter.repository.dao.PatientDao;
import cl.talavera.medical.core.port.AppointmentServicePort;
import cl.talavera.medical.mapper.AppointmentMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService implements AppointmentServicePort {
    private final AppointmentDaoRepository appointmentRepository;

    public AppointmentService(AppointmentDaoRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(AppointmentMapper::toDto)
                .toList();
    }

    @Override
    public AppointmentDto getAppointmentById(long id) {
        return appointmentRepository.findById(id)
                .map(AppointmentMapper::toDto)
                .orElse(null);
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto toCreate) {
        var dao = AppointmentMapper.toDao(toCreate);
        var saved = appointmentRepository.save(dao);
        return AppointmentMapper.toDto(saved);
    }

    @Override
    public AppointmentDto updateAppointment(long id, AppointmentDto updateRequest) {
        return appointmentRepository.findById(id)
                .map(existing -> {
                    if (updateRequest.getPatientId() != null) {
                        PatientDao patient = new PatientDao();
                        patient.setId(updateRequest.getPatientId());
                        existing.setPatient(patient);
                    }
                    if (updateRequest.getDoctorId() != null) {
                        DoctorDao doctor = new DoctorDao();
                        doctor.setId(updateRequest.getDoctorId());
                        existing.setDoctor(doctor);
                    }
                    existing.setDateTime(updateRequest.getAppointmentDate());
                    // Status and reason handling can be added if needed
                    var saved = appointmentRepository.save(existing);
                    return AppointmentMapper.toDto(saved);
                })
                .orElse(null);
    }

    @Override
    public void deleteAppointment(long id) {
        appointmentRepository.deleteById(id);
    }
    // Add other methods as needed
}
