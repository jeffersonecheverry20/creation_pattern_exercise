package com.jefferson.university.controller;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.facade.StudentFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentFacade studentFacade;

    public StudentController(final StudentFacade studentFacade) {
        this.studentFacade = studentFacade;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return this.studentFacade.getAllStudents();
    }

    @GetMapping("/{ID}")
    public StudentDTO getStudent(@PathVariable(name = "ID") String ID) {
        return this.studentFacade.getStudentByID(ID);
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentToCreate) {
        return this.studentFacade.createStudent(studentToCreate);
    }

    @PutMapping
    public StudentDTO updateStudent(@RequestBody StudentDTO studentToUpdate) {
        return this.studentFacade.createStudent(studentToUpdate);
    }

    @DeleteMapping("/{ID}")
    public StudentDTO deleteStudent(@PathVariable(name = "ID") String ID) {
        return this.studentFacade.deleteStudent(ID);
    }
}
