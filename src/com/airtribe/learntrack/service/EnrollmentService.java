package com.airtribe.learntrack.service;

import java.util.List;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Enrollment;

public interface EnrollmentService {
	
	void enrollStudent(Scanner scan);
	List<Enrollment> displayEnrollment();
	void updateEnrollment(Scanner scan);

}
