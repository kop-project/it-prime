package it.prom.professionalmanager.controllers.rest;

import it.prom.professionalmanager.dto.CoworkerDTO;
import it.prom.professionalmanager.model.Coworker;
import it.prom.professionalmanager.service.Converter;
import it.prom.professionalmanager.service.CoworkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest api для работы с сотрудниками
 */
@RestController
@RequestMapping(value = "/api/v1/coworkers")
public class CoworkerRestApi {

    private final CoworkersService coworkersService;

    @Autowired
    public CoworkerRestApi(CoworkersService coworkersService) {
        this.coworkersService = coworkersService;
    }

    @PostMapping
    private ResponseEntity<Coworker> addCoworker(@RequestBody CoworkerDTO coworkerDTO) {
        return ResponseEntity.ok(coworkersService.addCoworker(Converter.convertCoworkerDtoToEntity(coworkerDTO)));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Coworker> updateCoworker(@RequestBody CoworkerDTO coworkerDTO) {
        return ResponseEntity.ok(coworkersService.updateCoworker(Converter.convertCoworkerDtoToEntity(coworkerDTO)));
    }

    @GetMapping
    private ResponseEntity<List<Coworker>> getCoworkers() {
        return ResponseEntity.ok(coworkersService.getCoworkers());
    }

    @DeleteMapping
    private ResponseEntity deleteCoworker() {
        return null;
    }
}
