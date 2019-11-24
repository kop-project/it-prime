package it.prom.professionalmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность профессии
 */
@Entity
@Table(name = "PROFESSIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profession {

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


}
