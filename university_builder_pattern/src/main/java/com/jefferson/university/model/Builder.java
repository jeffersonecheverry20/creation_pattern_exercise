package com.jefferson.university.model;

import com.jefferson.university.enums.Disability;
import com.jefferson.university.enums.ResearchHotbed;

public class Builder {

	protected String ID;
	protected String name;
	protected String lastName;
	protected String email;
	protected boolean hasResearchHotbed;
	protected ResearchHotbed researchHotbed;
	protected Integer stratum;
	protected boolean hasDisability;
	protected Disability disability;
	protected String city;
	protected boolean hasLunch;
	protected Integer enrollmentFee;

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
