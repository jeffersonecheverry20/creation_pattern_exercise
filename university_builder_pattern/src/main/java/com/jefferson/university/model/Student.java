package com.jefferson.university.model;

import com.jefferson.university.enums.Disability;
import com.jefferson.university.enums.ResearchHotbed;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID;
    private String name;
    private String lastName;
    private String email;
    private boolean hasResearchHotbed;
    @Enumerated(EnumType.STRING)
    private ResearchHotbed researchHotbed;
    private Integer stratum;
    private boolean hasDisability;
    @Enumerated(EnumType.STRING)
    private Disability disability;
    private String city;
    private boolean hasLunch;
    private Integer enrollmentFee;

    public Student(final Builder builder) {
        this.ID = builder.ID;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.hasResearchHotbed = builder.hasResearchHotbed;
        this.researchHotbed = builder.researchHotbed;
        this.stratum = builder.stratum;
        this.hasDisability = builder.hasDisability;
        this.disability = builder.disability;
        this.city = builder.city;
        this.hasLunch = builder.hasLunch;
        this.enrollmentFee = builder.enrollmentFee;
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
    
