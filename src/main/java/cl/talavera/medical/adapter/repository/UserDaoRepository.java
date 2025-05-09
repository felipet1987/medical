package cl.talavera.medical.adapter.repository;

import cl.talavera.medical.adapter.repository.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDaoRepository extends JpaRepository<UserDao, Long> {
}
