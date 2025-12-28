package com.airtribe.learntrack.service;

import java.util.List;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Student;

public interface StudentService {

	void addStudent(Scanner scan);
	List<Student> displayAllStudent();
	void getStudentByID(Scanner scan);
	void deactivateStudent(Scanner scan);
	
}
