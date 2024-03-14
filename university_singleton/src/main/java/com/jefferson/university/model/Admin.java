package com.jefferson.university.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
	
	 private static Admin instancia;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID;
    private String name;
    private String lastName;

    private Admin() {
    }
    
    public static Admin getInstance() {
        if (instancia == null) {
            instancia = new Admin();
        }
        return instancia;
    }

	public Admin(String iD, String name, String lastName) {
		ID = iD;
		this.name = name;
		this.lastName = lastName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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
    
}
