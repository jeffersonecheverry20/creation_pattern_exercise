package com.jefferson.university.service;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.model.Student;
import com.jefferson.university.respository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudents() {
         List<Student> students = this.studentRepository.findAll();
         if (CollectionUtils.isEmpty(students)) {
             throw new RuntimeException("There are not students yet.");
         }

        return students.stream().map(student -> new StudentDTO(student.getID(),
                        student.getName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.isHasResearchHotbed(),
                        student.getResearchHotbed(),
                        student.getStratum(),
                        student.isHasDisability(),
                        student.getDisability(),
                        student.getCity(),
                        student.isHasLunch(),
                        student.getEnrollmentFee()))
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentByID(final String ID) {
        Student student = this.studentRepository.getReferenceById(ID);
        if (student == null) {
            throw new RuntimeException(String.format("Student %s not found", ID));
        }
        return new StudentDTO(student.getID(),
                student.getName(),
                student.getLastName(),
                student.getEmail(),
                student.isHasResearchHotbed(),
                student.getResearchHotbed(),
                student.getStratum(),
                student.isHasDisability(),
                student.getDisability(),
                student.getCity(),
                student.isHasLunch(),
                student.getEnrollmentFee());
    }

    public StudentDTO createStudent(final StudentDTO studentToCreate) {
        Student student = new Student();
        String name = studentToCreate.getName();
        student.setName(name);
        student.setLastName(studentToCreate.getLastName());
        student.setEmail(studentToCreate.getEmail());
        boolean hasResearchHotbed = studentToCreate.isHasResearchHotbed();
        student.setHasResearchHotbed(hasResearchHotbed);
        if (hasResearchHotbed) {
            if (studentToCreate.getResearchHotbed() == null) {
                throw new IllegalArgumentException(String.format("Does not find research hotbed for the student %s.", name));
            }
            student.setResearchHotbed(studentToCreate.getResearchHotbed());
        }
        Integer stratum = studentToCreate.getStratum();
        student.setStratum(stratum);
        if (stratum > 3) {
            student.setEnrollmentFee(studentToCreate.getEnrollmentFee());
        }
        boolean hasDisability = studentToCreate.isHasDisability();
        student.setHasDisability(hasDisability);
        if (hasDisability) {
            if (studentToCreate.getDisability() == null) {
                throw new IllegalArgumentException(String.format("Does not find disability for the student %s.", name));
            }
            student.setDisability(studentToCreate.getDisability());
        }
        String city = studentToCreate.getCity();
        student.setCity(city);
        student.setHasLunch(city.equalsIgnoreCase("CALI") ? true : false);
        this.studentRepository.save(student);

        return studentToCreate;
    }

    public StudentDTO updateStudent(final StudentDTO studentToUpdate) {
        Student student = new Student();
        String name = studentToUpdate.getName();
        student.setName(name);
        student.setLastName(studentToUpdate.getLastName());
        student.setEmail(studentToUpdate.getEmail());
        boolean hasResearchHotbed = studentToUpdate.isHasResearchHotbed();
        student.setHasResearchHotbed(hasResearchHotbed);
        if (hasResearchHotbed) {
            if (studentToUpdate.getResearchHotbed() == null) {
                throw new IllegalArgumentException(String.format("Does not find research hotbed for the student %s.", name));
            }
            student.setResearchHotbed(studentToUpdate.getResearchHotbed());
        }
        Integer stratum = studentToUpdate.getStratum();
        student.setStratum(stratum);
        if (stratum > 3) {
            student.setEnrollmentFee(studentToUpdate.getEnrollmentFee());
        }
        boolean hasDisability = studentToUpdate.isHasDisability();
        student.setHasDisability(hasDisability);
        if (hasDisability) {
            if (studentToUpdate.getDisability() == null) {
                throw new IllegalArgumentException(String.format("Does not find disability for the student %s.", name));
            }
            student.setDisability(studentToUpdate.getDisability());
        }
        String city = studentToUpdate.getCity();
        student.setCity(city);
        student.setHasLunch(city.equalsIgnoreCase("CALI") ? true : false);
        this.studentRepository.save(student);

        return studentToUpdate;
    }

    public StudentDTO deleteStudent(final String ID) {
        Student student = this.studentRepository.getReferenceById(ID);
        if (student == null) {
            throw new RuntimeException(String.format("Does not find the student %s.", ID));
        }
        this.studentRepository.delete(student);

        return new StudentDTO(student.getID(),
                student.getName(),
                student.getLastName(),
                student.getEmail(),
                student.isHasResearchHotbed(),
                student.getResearchHotbed(),
                student.getStratum(),
                student.isHasDisability(),
                student.getDisability(),
                student.getCity(),
                student.isHasLunch(),
                student.getEnrollmentFee());
    }
}
