package it.prom.professionalmanager.repository;

import it.prom.professionalmanager.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозитории для работы с профессиями
 */
@Repository
public interface ProfessionRepo extends JpaRepository<Profession, String> {
}
