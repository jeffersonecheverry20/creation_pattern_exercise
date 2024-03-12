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

    public Student() {
    }

    private Student(final Builder builder) {
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

    public static class Builder {
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

        public Builder hasResearchHotbed(final boolean hasResearchHotbed,
                                         final ResearchHotbed researchHotbed) {
            this.hasResearchHotbed = hasResearchHotbed;
            if (hasResearchHotbed) {
                if (researchHotbed == null) {
                    throw new IllegalArgumentException(String.format("Does not find research hotbed for the student %s.", name));
                }
                this.researchHotbed = researchHotbed;
            }
            return this;
        }

        public Builder stratum(final Integer stratum,
                               final Integer enrollmentFee) {
            this.stratum = stratum;
            if (stratum > 3) {
                if (enrollmentFee == 0) {
                    throw new RuntimeException("The enrollment fee is 0");
                }
                this.enrollmentFee = enrollmentFee;
            }
            return this;
        }

        public Builder hasDisability(final boolean hasDisability,
                                     final Disability disability) {
            this.hasDisability = hasDisability;
            if (hasDisability) {
                if (disability == null) {
                    throw new IllegalArgumentException(String.format("Does not find disability for the student %s.", name));
                }
                this.disability = disability;
            }
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            this.hasLunch = city.equalsIgnoreCase("CALI") ? false : true;
            return this;
        }

        public Builder hasLunch(final boolean hasLunch) {
            this.hasLunch = hasLunch;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
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
