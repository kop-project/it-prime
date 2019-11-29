package it.prom.professionalmanager.service;

import it.prom.professionalmanager.model.Profession;

import java.util.List;

/**
 * Сервис для работы с сотруднкиами
 */
public interface ProfessionsService {

    /**
     * Добавление сотрудника
     *
     * @return новые данные о сотруднике
     */
    public Profession addProfession(Profession Profession);

    /**
     * Обновление данных о сотруднике
     *
     * @return обновленные данные о сотруднике
     */
    public Profession updateProfession(Profession Profession);

    /**
     * @param id элемента
     *           Удаление данных о сотруднике
     */
    public void deleteProfession(String id);

    /**
     * Вернуть сотрудников
     *
     * @return список сотрудников
     */
    public List<Profession> getProfessions();

}
