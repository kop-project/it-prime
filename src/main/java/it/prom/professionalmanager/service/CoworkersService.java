package it.prom.professionalmanager.service;

import it.prom.professionalmanager.model.Coworker;

import java.util.List;

/**
 * Сервис для работы с сотруднкиами
 */
public interface CoworkersService {

    /**
     * Добавление сотрудника
     *
     * @return новые данные о сотруднике
     */
    public Coworker addCoworker(Coworker coworker);

    /**
     * Обновление данных о сотруднике
     *
     * @return обновленные данные о сотруднике
     */
    public Coworker updateCoworker(Coworker coworker);

    /**
     * @param id элемента
     *           Удаление данных о сотруднике
     */
    public void deleteCoworker(Long id);

    /**
     * Вернуть сотрудников
     *
     * @return список сотрудников
     */
    public List<Coworker> getCoworkers();

}
