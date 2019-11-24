package it.prom.professionalmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Тело запроса отдела
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    /**
     * id профессии
     */
    private Long id;

    /**
     * Наименование професии
     */
    private String name;

    /**
     * Примечание профессии
     */
    private String note;

    /**
     * id родительского отдела
     */
    private Long parentId;

}
