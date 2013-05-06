package com.example.labvezba.model;

public class LstItem {
	public String name;
	public String lastName;
	public String id;
	public String sex;
	
	public String getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
}
