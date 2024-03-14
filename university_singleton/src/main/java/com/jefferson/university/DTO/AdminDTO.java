package com.jefferson.university.DTO;



public class AdminDTO {
    private String ID;
    private String name;
    private String lastName;
    
	public AdminDTO() {
	}
	public AdminDTO(String iD, String name, String lastName) {
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
