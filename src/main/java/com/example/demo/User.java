package com.example.demo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Vehicle> vehicles;

    
    
    
    public User(Long id, String firstName, String lastName, List<Vehicle> vehicles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicles = vehicles;
	}

	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

	public String getFirstName1() {
		// TODO Auto-generated method stub
		return null;
	}
}
