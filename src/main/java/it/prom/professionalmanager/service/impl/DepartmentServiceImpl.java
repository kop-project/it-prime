package it.prom.professionalmanager.service.impl;

import it.prom.professionalmanager.model.Department;
import it.prom.professionalmanager.repository.DepartmentRepo;
import it.prom.professionalmanager.service.DepartmentsService;
import it.prom.professionalmanager.service.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentsService {

    private final DepartmentRepo departmentRepo;

    /**
     * Компонент выдачи сообщения в зависимости от локали
     */
    private final Messages messages;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepo DepartmentRepo, Messages messages) {
        this.departmentRepo = DepartmentRepo;
        this.messages = messages;
    }

    @Override
    public Department addDepartment(Department department) {
        if (department.getName() == null) {
            return departmentRepo.save(department);
        } else {
            throw new NullPointerException(messages.getMessage(""));
        }
    }

    @Override
    public Department updateDepartment(Department Department) {
        return departmentRepo.save(Department);
    }

    @Override
    public void deleteDepartment(String id) {
        Department Department = departmentRepo.findById(id).orElseThrow(() -> new NullPointerException("asdas"));
        departmentRepo.delete(Department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }
}
