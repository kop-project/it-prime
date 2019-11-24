package it.prom.professionalmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность отдела
 */
@Entity
@Table(name = "DEPARTMENTS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    /**
     * id профессии
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование професии
     */
    @Column(name = "name")
    private String name;

    /**
     * Примечание профессии
     */
    @Column(name = "note")
    private String note;

    /**
     * id родительского отдела
     */
    @Column(name = "parent_id")
    private Long parentId;

}
