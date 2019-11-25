package it.prom.professionalmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность сотрудника
 */
@Entity
@Table(name = "COWORKERS", schema = "PUBLIC")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coworker {

    /**
     * id сотрудника
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя сотрудника
     */
    @Column(name = "name")
    private String name;

    /**
     * Фамилия сотрудника
     */
    @Column(name = "lastname")
    private String lastname;

    /**
     * Отчество сотрудника
     */
    @Column(name = "surname")
    private String surname;

    /**
     * Примечание профессии
     */
    @Column(name = "note")
    private String note;

    /**
     * id отдела
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * id профессии
     */
    @Column(name = "profession_id")
    private Long professionId;

}
