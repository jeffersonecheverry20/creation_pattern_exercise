package com.jefferson.university.config;

import com.jefferson.university.enums.ResearchHotbed;
import com.jefferson.university.model.Student;
import com.jefferson.university.respository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataSetup {

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void setupData() {
        Student student = new Student.Builder()
                .name("Mathew")
                .lastName("Echeverry")
                .email("mathew.echeverry@gmail.com")
                .hasResearchHotbed(true, ResearchHotbed.SCIENCE_DATA)
                .stratum(5, 10000000)
                .hasDisability(false, null)
                .city("CALI")
                .build();
        this.studentRepository.saveAll(Arrays.asList(student));
    }
}
