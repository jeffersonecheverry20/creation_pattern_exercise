package com.jefferson.university.factory;

import org.springframework.stereotype.Component;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.model.Student;

@Component
public class ForeignStudent implements IStudent {
	
	
    @Override
    public Student createStudent(final StudentDTO studentDTO) {
        Student student = new Student();
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
