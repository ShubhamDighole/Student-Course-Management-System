package com.airtribe.learntrack.entity;

public class Course {

	/* id, courseName, description, durationInWeeks, active*/
	private static int idCounter =0;
	private int id;
	private String courseName;
	private String description;
	private long durationInWeeks;
	private boolean active;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getDurationInWeeks() {
		return durationInWeeks;
	}
	public void setDurationInWeeks(long durationInWeeks) {
		this.durationInWeeks = durationInWeeks;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Course ID=" + id + "\ncourseName=" + courseName + "\ndescription=" + description + "\ndurationInWeeks="
				+ durationInWeeks + "\nactive=" + active +"\n\n" +"" ;
	}
	
	public Course(int id, String courseName, String description, long durationInWeeks, boolean active) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.durationInWeeks = durationInWeeks;
		this.active = active;
	}
	
	public Course(String courseName, String description, long durationInWeeks) {
		super();
		this.id = ++idCounter;
		this.courseName = courseName;
		this.description = description;
		this.durationInWeeks = durationInWeeks;
		this.active = true;
	}
	public Course() {
		super();
	}
	
}
