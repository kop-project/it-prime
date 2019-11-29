package it.prom.professionalmanager.service;

import it.prom.professionalmanager.model.Department;

import java.util.List;

/**
 * Сервис для работы с сотруднкиами
 */
public interface DepartmentsService {

    /**
     * Добавление сотрудника
     *
     * @return новые данные о сотруднике
     */
    public Department addDepartment(Department Department);

    /**
     * Обновление данных о сотруднике
     *
     * @return обновленные данные о сотруднике
     */
    public Department updateDepartment(Department Department);

    /**
     * @param id элемента
     * Удаление данных о сотруднике
     */
    public void deleteDepartment(String id);

    /**
     * Вернуть сотрудников
     *
     * @return список сотрудников
     */
    public List<Department> getDepartments();

}
