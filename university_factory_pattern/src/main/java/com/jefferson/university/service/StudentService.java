package com.jefferson.university.service;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.enums.TypeStudent;
import com.jefferson.university.factory.StudentFactory;
import com.jefferson.university.model.Student;
import com.jefferson.university.respository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentFactory studentFactory;

    public StudentService(final StudentRepository studentRepository,
                          final StudentFactory studentFactory) {
        this.studentRepository = studentRepository;
        this.studentFactory = studentFactory;
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
        Student student;
        if (studentToCreate.getCity().equalsIgnoreCase("INTERNATIONAL")) {
            student = this.studentFactory.create(TypeStudent.FOREIGN_STUDENT).createStudent(studentToCreate);
        } else {
            student = this.studentFactory.create(TypeStudent.LOCAL_STUDENT).createStudent(studentToCreate);
        }
        this.studentRepository.save(student);

        return studentToCreate;
    }

    public StudentDTO updateStudent(final StudentDTO studentToUpdate) {
        Student student;
        if (studentToUpdate.getCity().equalsIgnoreCase("INTERNATIONAL")) {
            student = this.studentFactory.create(TypeStudent.FOREIGN_STUDENT).createStudent(studentToUpdate);
        } else {
            student = this.studentFactory.create(TypeStudent.LOCAL_STUDENT).createStudent(studentToUpdate);
        }
        this.studentRepository.save(student);

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
