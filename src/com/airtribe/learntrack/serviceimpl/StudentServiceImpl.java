package com.airtribe.learntrack.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.airtribe.learntrack.customexception.StudentNotFoundException;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.utils.UITexts;

public class StudentServiceImpl implements StudentService{
	
	private static List<Student> studentsList = new ArrayList<>();

	@Override
	public void addStudent(Scanner scan) {
		getDetails(scan);
	}

	private void getDetails(Scanner scan) {
		System.out.print("Student's First Name : " );
		String firstName = scan.next();
		System.out.print("Student's Last Name : " );
		String lastName = scan.next();
		
/*Adding Validation only for Email-id duplication*/		
		System.out.print("Student's Email : " );
		String email = scan.next();
		if(studentsList.stream()
				.anyMatch(a-> a.getEmail().equalsIgnoreCase(email))){
			System.err.println(UITexts.STUDENT_ALREADY_EXIST);
			return;
		}
			
		System.out.print("Student's Batch : " );
		String batch = scan.next();
		
		Student student = new Student(firstName, lastName, email, batch);
		studentsList.add(student);
		System.out.println(UITexts.STUDENT_ADDED_SUCESS);
	}

	@Override
	public List<Student> displayAllStudent() {
		return studentsList;
	}

	@Override
	public void getStudentByID(Scanner scan) {
		System.out.println("Please enter student_ID:");
		 while (!scan.hasNextInt()) {
			 System.err.println(UITexts.INVALID_INPUT);
		        scan.next();
		    }
			int searchId = scan.nextInt();
			Optional<Student> searchStudent = studentsList.stream()
			.filter(a-> a.getId()==searchId)
			.findFirst();
			if(searchStudent.isEmpty()) {
//				System.err.println(UITexts.STUDENT_NOT_EXIST);
				throw new StudentNotFoundException(searchId);
			}
			System.out.println(searchStudent.get());
	}

	@Override
	public void deactivateStudent(Scanner scan) {
		System.out.println("Please enter student_ID to deactivate:");
		 while (!scan.hasNextInt()) {
			 System.err.println(UITexts.INVALID_INPUT);
		        scan.next();
		    }
		 int searchId = scan.nextInt();
		Optional<Student> updatingStudent = studentsList.stream()
		.filter(a->a.getId()==searchId)
		.findFirst();
		if(updatingStudent.isEmpty()) {
//			System.err.println(UITexts.STUDENT_NOT_EXIST);
			throw new StudentNotFoundException(searchId);
		}
		updatingStudent.get().setActive(false);
	}
}
