package it.prom.professionalmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * тело запрса профессии
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionDTO {

    /**
     * Наименование професии
     */
    private String name;

    /**
     * Примечание профессии
     */
    private String note;

}
