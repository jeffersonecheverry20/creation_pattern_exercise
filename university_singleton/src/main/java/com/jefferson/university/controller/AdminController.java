package com.jefferson.university.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jefferson.university.DTO.AdminDTO;
import com.jefferson.university.facade.AdminFacade;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminFacade adminFacade;

    public AdminController(final AdminFacade adminFacade) {
        this.adminFacade = adminFacade;
    }

    @GetMapping
    public List<AdminDTO> getAllStudents() {
        return this.adminFacade.getAllStudents();
    }

    @GetMapping("/{ID}")
    public AdminDTO getStudent(@PathVariable(name = "ID") String ID) {
        return this.adminFacade.getStudentByID(ID);
    }

    @PostMapping
    public AdminDTO createStudent(@RequestBody AdminDTO adminToCreate) {
        return this.adminFacade.createStudent(adminToCreate);
    }

    @PutMapping
    public AdminDTO updateStudent(@RequestBody AdminDTO adminToUpdate) {
        return this.adminFacade.createStudent(adminToUpdate);
    }

    @DeleteMapping("/{ID}")
    public AdminDTO deleteStudent(@PathVariable(name = "ID") String ID) {
        return this.adminFacade.deleteStudent(ID);
    }
}
