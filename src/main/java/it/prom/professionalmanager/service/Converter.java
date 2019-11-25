package it.prom.professionalmanager.service;

import it.prom.professionalmanager.dto.CoworkerDTO;
import it.prom.professionalmanager.model.Coworker;

public class Converter {

    public static Coworker convertCoworkerDtoToEntity(CoworkerDTO coworkerDTO) {

        return Coworker.builder()
                .id(coworkerDTO.getId())
                .departmentId(coworkerDTO.getDepartmentId())
                .professionId(coworkerDTO.getProfessionId())
                .name(coworkerDTO.getName())
                .lastname(coworkerDTO.getLastname())
                .surname(coworkerDTO.getSurname())
                .note(coworkerDTO.getNote())
                .build();
    }
}
