package cl.talavera.medical.mapper;

import cl.talavera.medical.adapter.repository.dao.PatientDao;
import cl.talavera.medical.adapter.controller.dto.PatientDto;

public class PatientMapper {
    public static PatientDto toDto(PatientDao dao) {
        if (dao == null) return null;
        PatientDto dto = new PatientDto();
        dto.setId(dao.getId());
        dto.setAge(dao.getAge());
        dto.setFirstName(dao.getFirstName());
        dto.setLastName(dao.getLastName());
        dto.setEmail(dao.getEmail());
        dto.setPhone(dao.getPhone());
        return dto;
    }

    public static PatientDao toDao(PatientDto dto) {
        if (dto == null) return null;
        PatientDao dao = new PatientDao();
        dao.setId(dto.getId());
        dao.setFirstName(dto.getFirstName());
        dao.setLastName(dto.getLastName());
        dao.setEmail(dto.getEmail());
        dao.setPhone(dto.getPhone());
        return dao;
    }
}
