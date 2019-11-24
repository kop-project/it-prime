package it.prom.professionalmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Тело запроса сотрудника
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoworkerDTO {

    /**
     * id сотрудника
     */
    private Long id;

    /**
     * Имя сотрудника
     */
    private String name;

    /**
     * Фамилия сотрудника
     */
    private String lastname;

    /**
     * Отчество сотрудника
     */
    private String surname;

    /**
     * Примечание профессии
     */
    private String note;

    /**
     * id отдела
     */
    private Long departmentId;

    /**
     * id профессии
     */
    private Long professionId;

}
