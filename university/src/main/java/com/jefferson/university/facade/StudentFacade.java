package com.jefferson.university.facade;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.model.Student;
import com.jefferson.university.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentFacade {

     private final StudentService studentService;

    public StudentFacade(final StudentService studentService) {
        this.studentService = studentService;
    }

    public List<StudentDTO> getAllStudents() {
        // Business Logic.
        return this.studentService.getAllStudents();
    }

    public StudentDTO getStudentByID(final String ID) {
        // Validations.
        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException(String.format("The ID is null or empty", ID));
        }

        // Business Logic.
        return this.studentService.getStudentByID(ID);
    }

    public StudentDTO createStudent(final StudentDTO studentToCreate) {
        // Validations.
        if (studentToCreate == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.studentService.createStudent(studentToCreate);
    }

    public StudentDTO updateStudent(final StudentDTO studentToUpdate) {
        // Validations.
        if (studentToUpdate == null) {
            throw new IllegalArgumentException("The student to create is null");
        }

        // Business Logic.
        return this.studentService.updateStudent(studentToUpdate);
    }

    public StudentDTO deleteStudent(final String ID) {
        // Validations.
        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException(String.format("The ID is null or empty", ID));
        }

        // Business Logic.
        return this.studentService.deleteStudent(ID);
    }


}
