package it.prom.professionalmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность отдела
 */
@Data
@Entity
@Table(name = "DEPARTMENTS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    /**
     * Наименование професии
     */
    @Id
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
    @Column(name = "parent_name")
    private String parentId;
}
