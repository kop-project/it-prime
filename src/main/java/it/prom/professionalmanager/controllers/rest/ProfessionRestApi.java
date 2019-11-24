package it.prom.professionalmanager.controllers.rest;

import it.prom.professionalmanager.model.Profession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest api для работы с профессиями
 */
@RestController
@RequestMapping(value = "/api/v1/profession")
public class ProfessionRestApi {

    @PostMapping
    private ResponseEntity<Profession> addProfession(){
        return null;
    }

    @PutMapping
    private ResponseEntity<Profession> updateProfession (){
        return null;
    }

    @GetMapping
    private ResponseEntity<List<Profession>> getProfessions(){
        return null;
    }

    @DeleteMapping
    private ResponseEntity deleteProfession(){
        return null;
    }

}
