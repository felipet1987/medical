package cl.talavera.medical.adapter.repository;

import cl.talavera.medical.adapter.repository.dao.DoctorDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDaoRepository extends JpaRepository<DoctorDao, Long> {
}
