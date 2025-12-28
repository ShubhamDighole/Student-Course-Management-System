package com.airtribe.learntrack.controller;

import java.util.Scanner;

import com.airtribe.learntrack.customexception.StudentNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.serviceimpl.CourseServiceImpl;
import com.airtribe.learntrack.serviceimpl.EnrollmentServiceImpl;
import com.airtribe.learntrack.utils.UITexts;

public class EnrollmentController {

	public void displayOptions(Scanner scan) {
		
		EnrollmentService enrollmentService = new EnrollmentServiceImpl();
		while(true) {
			System.out.print(UITexts.ENORLLMENT_PAGE_OPTIONS);
		 if (!scan.hasNextInt()) {
			 System.err.println(UITexts.INVALID_INPUT);
		        scan.next();
		        continue;
		    }
			int selection = scan.nextInt();
			switch (selection) {
				case 1-> {
					enrollmentService.enrollStudent(scan);
				}
				case 2-> {
					 System.out.println(enrollmentService.displayEnrollment());
				}
				
				case 3 -> {
					enrollmentService.updateEnrollment(scan);
				}
				case 0 ->{
					System.out.println(UITexts.EXIT_ENROLLMENT_BANNER);
					return;
				}
				default -> {
					System.err.println(UITexts.INVALID_SELECTION);
				}
			}
		}
	
 	}

	public void begin(Scanner scan) {

		System.out.print(UITexts.ENROLLMENT_BANNER);
		displayOptions(scan);
		
	}
}
