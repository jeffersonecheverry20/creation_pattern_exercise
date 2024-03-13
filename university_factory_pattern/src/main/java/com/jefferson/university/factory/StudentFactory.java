package com.jefferson.university.factory;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.enums.TypeStudent;
import com.jefferson.university.model.Student;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {

	@Autowired
	private ForeignStudent foreignStudentFactory;
	@Autowired
	private LocalStudent localStudentFactory;
	


	public Student create(TypeStudent typeStudent, StudentDTO studentToUpdate) {
		
		Map<TypeStudent, Student> studentMap = new HashMap<>(){
			private static final long serialVersionUID = 1L;
		{
			put(TypeStudent.LOCAL_STUDENT,localStudentFactory.createStudent(studentToUpdate));
			put(TypeStudent.FOREIGN_STUDENT,foreignStudentFactory.createStudent(studentToUpdate));
		}};
		return studentMap.get(typeStudent);

	}
}
