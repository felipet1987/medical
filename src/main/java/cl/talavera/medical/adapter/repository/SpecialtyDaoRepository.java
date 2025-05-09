package cl.talavera.medical.adapter.repository;

import cl.talavera.medical.adapter.repository.dao.SpecialtyDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyDaoRepository extends JpaRepository<SpecialtyDao, Long> {
}
