package it.prom.professionalmanager.controllers.rest;

import it.prom.professionalmanager.dto.ProfessionDTO;
import it.prom.professionalmanager.model.Profession;
import it.prom.professionalmanager.service.ProfessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest api для работы с профессиями
 */
@RestController
@RequestMapping(value = "/api/v1/professions")
public class ProfessionRestApi {


    private final ProfessionsService professionsService;

    @Autowired
    public ProfessionRestApi(ProfessionsService ProfessionsService) {
        this.professionsService = ProfessionsService;
    }

    @PostMapping
    private ResponseEntity<Profession> addProfession(@RequestBody ProfessionDTO ProfessionDTO) {
        // return ResponseEntity.ok(professionsService.addProfession(Converter.convertProfessionDtoToEntity(ProfessionDTO)));
        return null;
    }

    @PutMapping
    private ResponseEntity<Profession> updateProfession(@RequestBody ProfessionDTO ProfessionDTO) {
        //  return ResponseEntity.ok(professionsService.updateProfession(Converter.convertProfessionDtoToEntity(ProfessionDTO)));
        return null;
    }

    @GetMapping
    private ResponseEntity<List<Profession>> getProfessions() {
        return ResponseEntity.ok(professionsService.getProfessions());
    }

    @DeleteMapping
    private ResponseEntity deleteProfession(@RequestParam(name = "id") String id) {
        professionsService.deleteProfession(id);
        return ResponseEntity.ok().build();
    }

}
