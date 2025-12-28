package com.airtribe.learntrack.customexception;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(int searchId) {
		super("Student did not found with Student_id : " +searchId);
	}
}