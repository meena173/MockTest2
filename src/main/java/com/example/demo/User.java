package com.example.demo;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String First_name;
	private String Last_name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Vechicle>vehicle;
	
	public User(int id, String first_name, String last_name) {
		super();
		this.id = id;
		First_name = first_name;
		Last_name = last_name;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public Vechicle[] getVechicle() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setVechicle(List<Vechicle> list) {
		// TODO Auto-generated method stub
		
	}
	public User save(User ue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
