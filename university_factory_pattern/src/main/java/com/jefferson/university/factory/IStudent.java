package com.jefferson.university.factory;

import com.jefferson.university.DTO.StudentDTO;
import com.jefferson.university.model.Student;

public interface IStudent {
	
		public Student createStudent(final StudentDTO studentDTO);

}
