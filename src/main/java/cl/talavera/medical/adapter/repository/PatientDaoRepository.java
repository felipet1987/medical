package cl.talavera.medical.adapter.repository;

import cl.talavera.medical.adapter.repository.dao.PatientDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDaoRepository extends JpaRepository<PatientDao, Long> {
}
