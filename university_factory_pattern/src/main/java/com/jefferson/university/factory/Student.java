package com.jefferson.university.factory;

import com.jefferson.university.DTO.StudentDTO;

@FunctionalInterface
public interface Student {
    com.jefferson.university.model.Student createStudent(final StudentDTO studentDTO);
}
