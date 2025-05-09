package cl.talavera.medical.mapper;

import cl.talavera.medical.adapter.controller.dto.AppointmentDto;
import cl.talavera.medical.adapter.repository.dao.AppointmentDao;
import cl.talavera.medical.adapter.repository.dao.DoctorDao;
import cl.talavera.medical.adapter.repository.dao.PatientDao;

public class AppointmentMapper {
    public static AppointmentDto toDto(AppointmentDao appointmentDao) {
        if (appointmentDao == null) return null;
        AppointmentDto dto = new AppointmentDto();
        dto.setId(appointmentDao.getId());
        dto.setPatientId(appointmentDao.getPatient() != null ? appointmentDao.getPatient().getId() : null);
        dto.setDoctorId(appointmentDao.getDoctor() != null ? appointmentDao.getDoctor().getId() : null);
        dto.setAppointmentDate(appointmentDao.getDateTime());
        dto.setReason(appointmentDao.getReason());
        return dto;
    }

    public static AppointmentDao toDao(AppointmentDto dto) {
        if (dto == null) return null;
        AppointmentDao dao = new AppointmentDao();
        dao.setId(dto.getId());
        if (dto.getPatientId() != null) {
            PatientDao patient = new PatientDao();
            patient.setId(dto.getPatientId());
            dao.setPatient(patient);
        }
        if (dto.getDoctorId() != null) {
            DoctorDao doctor = new DoctorDao();
            doctor.setId(dto.getDoctorId());
            dao.setDoctor(doctor);
        }
        dao.setDateTime(dto.getAppointmentDate());
        dao.setReason(dto.getReason());
        dao.setStatus(AppointmentDao.AppointmentStatus.SCHEDULED);
        return dao;
    }
}
