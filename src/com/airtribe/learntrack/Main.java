package com.airtribe.learntrack;

import java.util.Scanner;

import com.airtribe.learntrack.controller.CourseController;
import com.airtribe.learntrack.controller.EnrollmentController;
import com.airtribe.learntrack.controller.StudentController;
import com.airtribe.learntrack.utils.UITexts;

public class Main {
	public static void main(String[] args) {

		/* Displayy welcome Banner */
		System.out.println(UITexts.MAIN_BANNER);

		displayOption();
	}

	private static void displayOption() {
		Scanner scan = new Scanner(System.in);
		StudentController studentController = new StudentController();
		EnrollmentController enrollmentController = new EnrollmentController();
		CourseController courseController = new CourseController();
		
		/* Displayy Main Option */

		while(true) {
		System.out.print(UITexts.MAIN_PAGE_OPTIONS);
		   if (!scan.hasNextInt()) {
			   System.err.println(UITexts.INVALID_INPUT);
			   scan.next();
		        continue;
		    }
		    int selection = scan.nextInt();
			switch (selection) {
				case 1-> {
					studentController.begin(scan);  
				}
				case 2-> {
					 courseController.begin(scan);
				}
				case 3-> {
					 enrollmentController.begin(scan);
				}
				case 4 -> {
					System.out.println(UITexts.EXIT_BANNER);
					return;
				}
				default -> {
					System.err.println(UITexts.INVALID_SELECTION);
				}
			}
		}
	}

}
