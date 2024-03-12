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

        return students.stream().map(student -> new StudentDTO(student))
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentByID(final String ID) {
        Student student = this.studentRepository.getReferenceById(ID);
        if (student == null) {
            throw new RuntimeException(String.format("Student %s not found", ID));
        }
        return new StudentDTO(student);
    }

    public StudentDTO createStudent(final StudentDTO studentToCreate) {
        Student.Builder student = new Student.Builder()
                .name(studentToCreate.getName())
                .lastName(studentToCreate.getLastName())
                .email(studentToCreate.getEmail())
                .hasResearchHotbed(studentToCreate.isHasResearchHotbed(), studentToCreate.getResearchHotbed())
                .stratum(studentToCreate.getStratum(),studentToCreate.getEnrollmentFee())
                .hasDisability(studentToCreate.isHasDisability(), studentToCreate.getDisability())
                .city(studentToCreate.getCity());
        this.studentRepository.save(student.build());

        return studentToCreate;
    }

    public StudentDTO updateStudent(final StudentDTO studentToUpdate) {
        Student.Builder student = new Student.Builder()
                .name(studentToUpdate.getName())
                .lastName(studentToUpdate.getLastName())
                .email(studentToUpdate.getEmail())
                .hasResearchHotbed(studentToUpdate.isHasResearchHotbed(), studentToUpdate.getResearchHotbed())
                .stratum(studentToUpdate.getStratum(),studentToUpdate.getEnrollmentFee())
                .hasDisability(studentToUpdate.isHasDisability(), studentToUpdate.getDisability())
                .city(studentToUpdate.getCity());
        this.studentRepository.save(student.build());

        return studentToUpdate;
    }

    public StudentDTO deleteStudent(final String ID) {
        Student student = this.studentRepository.getReferenceById(ID);
        if (student == null) {
            throw new RuntimeException(String.format("Does not find the student %s.", ID));
        }
        this.studentRepository.delete(student);

        return new StudentDTO(student);
    }
}
