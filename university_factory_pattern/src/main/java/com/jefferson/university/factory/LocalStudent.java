package com.jefferson.university.factory;

import org.springframework.stereotype.Component;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.model.Student;

@Component
public class LocalStudent implements IStudent {
    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();
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
