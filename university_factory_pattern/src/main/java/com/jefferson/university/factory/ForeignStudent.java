package com.jefferson.university.factory;

import com.jefferson.university.DTO.StudentDTO;

public class ForeignStudent implements Student {
    @Override
    public com.jefferson.university.model.Student createStudent(final StudentDTO studentDTO) {
        com.jefferson.university.model.Student student = new com.jefferson.university.model.Student();
        String name = studentDTO.getName();
        student.setName(name);
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setHasResearchHotbed(false);
        student.setStratum(studentDTO.getStratum());
        Integer enrollmentFee = studentDTO.getEnrollmentFee();
        if (enrollmentFee == 0) {
            throw new IllegalArgumentException(String.format("The enrollment fee is required for the student %s.", name));
        }
        student.setEnrollmentFee(enrollmentFee);
        boolean hasDisability = studentDTO.isHasDisability();
        student.setHasDisability(hasDisability);
        if (hasDisability) {
            if (studentDTO.getDisability() == null) {
                throw new IllegalArgumentException(String.format("The disability is null for the student %s.", name));
            }
            student.setDisability(studentDTO.getDisability());
        }
        student.setCity(studentDTO.getCity());
        student.setHasLunch(true);

        return student;
    }
}
