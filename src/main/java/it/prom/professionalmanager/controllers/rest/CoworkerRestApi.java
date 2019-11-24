package it.prom.professionalmanager.controllers.rest;

import it.prom.professionalmanager.model.Coworker;
import it.prom.professionalmanager.model.Profession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest api для работы с сотрудниками
 */
@RestController
@RequestMapping(value = "/api/v1/coworkers")
public class CoworkerRestApi {

    @PostMapping
    private ResponseEntity<Coworker> addCoworker(){
        return null;
    }

    @PutMapping
    private ResponseEntity<Coworker> updateCoworker (){
        return null;
    }

    @GetMapping
    private ResponseEntity<List<Profession>> getCoworkers(){
        return null;
    }

    @DeleteMapping
    private ResponseEntity deleteCoworker(){
        return null;
    }
}
