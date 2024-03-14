package com.jefferson.university.config;

import com.jefferson.university.enums.ResearchHotbed;
import com.jefferson.university.model.Admin;
import com.jefferson.university.model.Student;
import com.jefferson.university.respository.AdminRepository;
import com.jefferson.university.respository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataSetup {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired AdminRepository adminRepository;

    @PostConstruct
    public void setupData() {
        Student student = new Student();
        student.setName("Mathew");
        student.setLastName("Echeverry");
        student.setEmail("mathew.echeverry@gmail.com");
        student.setHasResearchHotbed(true);
        student.setResearchHotbed(ResearchHotbed.SCIENCE_DATA);
        student.setStratum(5);
        student.setEnrollmentFee(10000000);
        student.setHasDisability(false);
        student.setCity("CALI");
        student.setHasLunch(false);
        this.studentRepository.saveAll(Arrays.asList(student));
    }
    
    @PostConstruct
    public void setupData2() {
        Admin admin =  Admin.getInstance();
        admin.setName("Mathew");
        admin.setLastName("Echeverry");

        this.adminRepository.saveAll(Arrays.asList(admin));
    }
}
