package it.prom.professionalmanager.repository;

import it.prom.professionalmanager.model.Coworker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозитории для работы с сотрудниками
 */
@Repository
public interface CoworkerRepo extends JpaRepository<Coworker, Long> {
}
