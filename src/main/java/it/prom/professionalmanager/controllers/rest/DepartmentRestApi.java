package it.prom.professionalmanager.controllers.rest;

import it.prom.professionalmanager.dto.DepartmentDTO;
import it.prom.professionalmanager.model.Department;
import it.prom.professionalmanager.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest api для работы с отделами
 */
@RestController
@RequestMapping(value = "/api/v1/departments")
public class DepartmentRestApi {

    private final DepartmentsService departmentsService;

    @Autowired
    public DepartmentRestApi(DepartmentsService DepartmentsService) {
        this.departmentsService = DepartmentsService;
    }

    @PostMapping
    private ResponseEntity<Department> addDepartment(@RequestBody DepartmentDTO DepartmentDTO) {
       // return ResponseEntity.ok(departmentsService.addDepartment(Converter.convertDepartmentDtoToEntity(DepartmentDTO)));
        return null;
    }

    @PutMapping
    private ResponseEntity<Department> updateDepartment(@RequestBody DepartmentDTO DepartmentDTO) {
      //  return ResponseEntity.ok(departmentsService.updateDepartment(Converter.convertDepartmentDtoToEntity(DepartmentDTO)));
        return null;
    }

    @GetMapping
    private ResponseEntity<List<Department>> getDepartments() {
        return ResponseEntity.ok(departmentsService.getDepartments());
    }

    @DeleteMapping
    private ResponseEntity deleteDepartment(@RequestParam(name = "id") String id) {
        departmentsService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }
}
