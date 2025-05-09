package cl.talavera.medical.adapter.repository;

import cl.talavera.medical.adapter.repository.dao.AppointmentDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDaoRepository extends JpaRepository<AppointmentDao, Long> {
}
