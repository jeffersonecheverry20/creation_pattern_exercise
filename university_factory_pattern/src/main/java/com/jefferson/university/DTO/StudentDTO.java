package com.jefferson.university.DTO;

import com.jefferson.university.enums.Disability;
import com.jefferson.university.enums.ResearchHotbed;
import com.jefferson.university.model.Student;

public class StudentDTO {
    private String ID;
    private String name;
    private String lastName;
    private String email;
    private boolean hasResearchHotbed;
    private ResearchHotbed researchHotbed;
    private Integer stratum;
    private boolean hasDisability;
    private Disability disability;
    private String city;
    private boolean hasLunch;
    private Integer enrollmentFee;

    public StudentDTO() {
    }

    public StudentDTO(final Student student) {
        this.ID = student.getID();
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.hasResearchHotbed = student.isHasResearchHotbed();
        this.researchHotbed = student.getResearchHotbed();
        this.stratum = student.getStratum();
        this.hasDisability = student.isHasDisability();
        this.disability = student.getDisability();
        this.city = student.getCity();
        this.hasLunch = student.isHasLunch();
        this.enrollmentFee = student.getEnrollmentFee();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isHasResearchHotbed() {
        return hasResearchHotbed;
    }

    public ResearchHotbed getResearchHotbed() {
        return researchHotbed;
    }

    public Integer getStratum() {
        return stratum;
    }

    public boolean isHasDisability() {
        return hasDisability;
    }

    public Disability getDisability() {
        return disability;
    }

    public String getCity() {
        return city;
    }

    public boolean isHasLunch() {
        return hasLunch;
    }

    public Integer getEnrollmentFee() {
        return enrollmentFee;
    }
}
