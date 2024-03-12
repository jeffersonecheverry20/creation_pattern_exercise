package com.jefferson.university.factory;

import com.jefferson.university.DTO.StudentDTO;

public class LocalStudent implements Student {
    @Override
    public com.jefferson.university.model.Student createStudent(StudentDTO studentDTO) {
        com.jefferson.university.model.Student student = new com.jefferson.university.model.Student();
        String name = studentDTO.getName();
        student.setName(name);
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        boolean hasResearchHotbed = studentDTO.isHasResearchHotbed();
        student.setHasResearchHotbed(hasResearchHotbed);
        if (hasResearchHotbed) {
            if (studentDTO.getResearchHotbed() == null) {
                throw new IllegalArgumentException(String.format("The research hotbed is null for the student %s.", name));
            }
            student.setResearchHotbed(studentDTO.getResearchHotbed());
        }
        Integer stratum = studentDTO.getStratum();
        student.setStratum(stratum);
        if (stratum > 3) {
            Integer enrollmentFee = studentDTO.getEnrollmentFee();
            if (enrollmentFee == 0) {
                throw new IllegalArgumentException(String.format("The enrollment fee is required for the student %s.", name));
            }
            student.setEnrollmentFee(enrollmentFee);
        }
        boolean hasDisability = studentDTO.isHasDisability();
        student.setHasDisability(hasDisability);
        if (hasDisability) {
            if (studentDTO.getDisability() == null) {
                throw new IllegalArgumentException(String.format("The disability is null for the student %s.", name));
            }
            student.setDisability(studentDTO.getDisability());
        }
        String city = studentDTO.getCity();
        student.setCity(city);
        student.setHasLunch(city.equalsIgnoreCase("CALI") ? false : true);

        return student;
    }
}
