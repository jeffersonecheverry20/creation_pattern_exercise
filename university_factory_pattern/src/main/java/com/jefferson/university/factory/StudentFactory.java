package com.jefferson.university.factory;

import com.jefferson.university.enums.TypeStudent;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {

    private ForeignStudent foreignStudentFactory;
    private LocalStudent localStudentFactory;

    public Student create(final TypeStudent typeStudent) {
        switch (typeStudent) {
            case LOCAL_STUDENT -> {
                return localStudentFactory = new LocalStudent();
            }
            case FOREIGN_STUDENT -> {
                return foreignStudentFactory = new ForeignStudent();
            }
            default -> {
                throw new IllegalArgumentException(String.format("The type does not exist", typeStudent));
            }
        }
    }

}
