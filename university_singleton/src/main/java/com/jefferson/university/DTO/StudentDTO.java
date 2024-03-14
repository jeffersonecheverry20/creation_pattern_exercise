package com.jefferson.university.DTO;

import com.jefferson.university.enums.Disability;
import com.jefferson.university.enums.ResearchHotbed;

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

    public StudentDTO(final String ID,
                      final String name,
                      final String lastName,
                      final String email,
                      final boolean hasResearchHotbed,
                      final ResearchHotbed researchHotbed,
                      final Integer stratum,
                      final boolean hasDisability,
                      final Disability disability,
                      final String city,
                      final boolean hasLunch,
                      final Integer enrollmentFee) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.hasResearchHotbed = hasResearchHotbed;
        this.researchHotbed = researchHotbed;
        this.stratum = stratum;
        this.hasDisability = hasDisability;
        this.disability = disability;
        this.city = city;
        this.hasLunch = hasLunch;
        this.enrollmentFee = enrollmentFee;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHasResearchHotbed() {
        return hasResearchHotbed;
    }

    public void setHasResearchHotbed(boolean hasResearchHotbed) {
        this.hasResearchHotbed = hasResearchHotbed;
    }

    public ResearchHotbed getResearchHotbed() {
        return researchHotbed;
    }

    public void setResearchHotbed(ResearchHotbed researchHotbed) {
        this.researchHotbed = researchHotbed;
    }

    public Integer getStratum() {
        return stratum;
    }

    public void setStratum(Integer stratum) {
        this.stratum = stratum;
    }

    public boolean isHasDisability() {
        return hasDisability;
    }

    public void setHasDisability(boolean hasDisability) {
        this.hasDisability = hasDisability;
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isHasLunch() {
        return hasLunch;
    }

    public void setHasLunch(boolean hasLunch) {
        this.hasLunch = hasLunch;
    }

    public Integer getEnrollmentFee() {
        return enrollmentFee;
    }

    public void setEnrollmentFee(Integer enrollmentFee) {
        this.enrollmentFee = enrollmentFee;
    }
}
