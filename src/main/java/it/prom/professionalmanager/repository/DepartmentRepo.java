package it.prom.professionalmanager.repository;

import it.prom.professionalmanager.model.Coworker;
import it.prom.professionalmanager.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозитории для работы с отделами
 */
@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
}
