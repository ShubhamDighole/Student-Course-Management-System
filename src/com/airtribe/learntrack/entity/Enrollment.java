package com.airtribe.learntrack.entity;

import java.time.LocalDate;

import com.airtribe.learntrack.utils.Status;

public class Enrollment {
	
    private static int counter=0;
	
	/*id, studentId, courseId, enrollmentDate, status (e.g., "ACTIVE", "COMPLETED", "CANCELLED" as String or simple enum if you want slightly advanced)*/

	private int id;
	private Student student;
	private Course course;
    private LocalDate enrollmentDate;
    private Status status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	
	public Enrollment(Student student, Course course, LocalDate enrollmentDate) {
		super();
		this.id = counter++;
		this.student = student;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
		this.status = Status.ACTIVE;
	}
	public Enrollment() {
		super();
	}
	@Override
	public String toString() {
		return "Enrollment ID=" + id + "\nstudent=" + student.getId() + "\ncourse=" + course.getId() + "\nenrollmentDate="
				+ enrollmentDate + "\nstatus=" + status + "\n\n" +"";
	}
    
}
