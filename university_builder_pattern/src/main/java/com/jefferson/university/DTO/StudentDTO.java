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

    /*private StudentDTO(final Builder builder) {
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
    }*/

    public StudentDTO(Student student) {
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

    /*public static class Builder {
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

        public Builder ID(final String ID) {
            this.ID = ID;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder hasResearchHotbed(final boolean hasResearchHotbed) {
            this.hasResearchHotbed = hasResearchHotbed;
            return this;
        }

        public Builder researchHotbed(final ResearchHotbed researchHotbed) {
            this.researchHotbed = researchHotbed;
            return this;
        }

        public Builder stratum(final Integer stratum) {
            this.stratum = stratum;
            return this;
        }

        public Builder hasDisability(final boolean hasDisability) {
            this.hasDisability = hasDisability;
            return this;
        }

        public Builder disability(final Disability disability) {
            this.disability = disability;
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder hasLunch(final boolean hasLunch) {
            this.hasLunch = hasLunch;
            return this;
        }

        public Builder enrollmentFee(final Integer enrollmentFee) {
            this.enrollmentFee = enrollmentFee;
            return this;
        }

        public StudentDTO build() {
            return new StudentDTO(this);
        }
    }*/

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
