package com.airtribe.learntrack.entity;
public class Student extends Person{

	private static int idCounter=0;
	/*
	Fields: id, firstName, lastName, email, batch, active (boolean)*/

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String batch;
	private boolean active;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "STUDENT ID=" + id + "\nfirstName=" + firstName + "\nlastName=" + lastName + "\nemail=" + email
				+ "\nbatch=" + batch + "\nactive=" + active +"\n\n"+ "";
	}
	public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.batch = batch;
		this.active = active;		//activating on each new call bydefault.
	}
	public Student() {
		super();
	}
	public Student(String firstName, String lastName, String email, String batch) {
		super();
		this.id = ++idCounter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.batch = batch;
		this.active=true;
	}
	
	public String getDisplayName() {
		return "From Student Class";
	}
	
}
