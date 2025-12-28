package com.airtribe.learntrack.controller;

import java.util.Scanner;

import com.airtribe.learntrack.customexception.StudentNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.serviceimpl.CourseServiceImpl;
import com.airtribe.learntrack.utils.UITexts;

public class CourseController {

	public void displayOptions(Scanner scan) {
		
		CourseService courseService = new CourseServiceImpl();
		while(true) {
			System.out.print(UITexts.COURSE_PAGE_OPTIONS);
		 if (!scan.hasNextInt()) {
			 System.err.println(UITexts.INVALID_INPUT);
		        scan.next();
		        continue;
		    }
			int selection = scan.nextInt();
			switch (selection) {
				case 1-> {
					courseService.addCourse(scan);
				}
				case 2-> {
					 System.out.println(courseService.displayAllCourse());
				}
				
/*Handling through Custom Exception*/				
				case 3 -> {
					try {
						courseService.activateDeactivateStudent(scan);
					}catch(StudentNotFoundException e) {
						System.err.println(e.getMessage());
					}
				}
				case 0 ->{
					System.out.println(UITexts.EXIT_COURSE_BANNER);
					return;
				}
				default -> {
					System.err.println(UITexts.INVALID_SELECTION);
				}
			}
		}
	}

	public void begin(Scanner scan) {
		System.out.print(UITexts.COURSE_BANNER);
		displayOptions(scan);
	}

}
