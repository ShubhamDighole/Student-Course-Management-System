package com.airtribe.learntrack.controller;

import java.util.Scanner;

import com.airtribe.learntrack.customexception.StudentNotFoundException;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.serviceimpl.StudentServiceImpl;
import com.airtribe.learntrack.utils.UITexts;

public class StudentController {

	public void begin(Scanner scan) {
		System.out.print(UITexts.STUDENT_BANNER);
		displayOption(scan);
	}
	
	private static void displayOption(Scanner scan) {
		
		StudentService studentService = new StudentServiceImpl();
		while(true) {
			System.out.print(UITexts.STUDENT_PAGE_OPTIONS);
		 if (!scan.hasNextInt()) {
			 System.err.println(UITexts.INVALID_INPUT);
		        scan.next();
		        continue;
		    }
			int selection = scan.nextInt();
			switch (selection) {
				case 1-> {
					studentService.addStudent(scan);
				}
				case 2-> {
					 System.out.println(studentService.displayAllStudent());
				}
				case 3-> {
					try {
						studentService.getStudentByID(scan);
					}catch(StudentNotFoundException e) {
						System.err.println(e.getMessage());
					}
				}
				case 4 -> {
					try {
						studentService.deactivateStudent(scan);
					}catch(StudentNotFoundException e) {
						System.err.println(e.getMessage());
					}
				}
				case 0 ->{
					System.out.println(UITexts.EXIT_STUDENT_BANNER);
					return;
				}
				default -> {
					System.err.println(UITexts.INVALID_SELECTION);
				}
			}
		}
	}
}
