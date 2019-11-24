package it.prom.professionalmanager.controllers.rest;

import it.prom.professionalmanager.model.Department;
import it.prom.professionalmanager.model.Profession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest api для работы с отделами
 */
@RestController
@RequestMapping(value = "/api/v1/departments")
public class DepartmentRestApi {

    @PostMapping
    private ResponseEntity<Department> addDepartment(){
        return null;
    }

    @PutMapping
    private ResponseEntity<Department> updateDepartment (){
        return null;
    }

    @GetMapping
    private ResponseEntity<List<Profession>> getDepartments(){
        return null;
    }

    @DeleteMapping
    private ResponseEntity deleteDepartment(){
        return null;
    }
}
