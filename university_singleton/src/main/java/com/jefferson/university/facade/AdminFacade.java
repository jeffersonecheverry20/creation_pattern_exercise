package com.jefferson.university.facade;

import com.jefferson.university.DTO.AdminDTO;
import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.model.Student;
import com.jefferson.university.service.AdminService;
import com.jefferson.university.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminFacade {

     private final AdminService adminService;

    public AdminFacade(final AdminService adminService) {
        this.adminService = adminService;
    }

    public List<AdminDTO> getAllStudents() {
        // Business Logic.
        return this.adminService.getAllStudents();
    }

    public AdminDTO getStudentByID(final String ID) {
        // Validations.
        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException(String.format("The ID is null or empty", ID));
        }

        // Business Logic.
        return this.adminService.getStudentByID(ID);
    }

    public AdminDTO createStudent(final AdminDTO adminToCreate) {
        // Validations.
        if (adminToCreate == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.adminService.createStudent(adminToCreate);
    }

    public AdminDTO updateStudent(final AdminDTO adminToUpdate) {
        // Validations.
        if (adminToUpdate == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.adminService.updateStudent(adminToUpdate);
    }

    public AdminDTO deleteStudent(final String ID) {
        // Validations.
        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException(String.format("The ID is null or empty", ID));
        }

        // Business Logic.
        return this.adminService.deleteStudent(ID);
    }


}
