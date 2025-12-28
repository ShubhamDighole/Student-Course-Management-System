package com.airtribe.learntrack.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.utils.UITexts;

public class CourseServiceImpl implements CourseService{
	
	private static List<Course> courseList = new ArrayList<>();

	@Override
	public void addCourse(Scanner scan) {
		scan.nextLine();
		getDetails(scan);
	}

	private void getDetails(Scanner scan) {
		/*		this.courseName = courseName;
		this.description = description;
		this.durationInWeeks = durationInWeeks;*/
		
		
		System.out.print("Course Name : ");
		String courseName = scan.nextLine();

		System.out.print("Course Description : ");
		
		String description = scan.nextLine();

		System.out.print("Duration in Weeks : ");
		while (!scan.hasNextInt()) {
		    System.err.println(UITexts.INVALID_INPUT);
		    scan.next();
		}
		int durationWeeks = scan.nextInt();		
		Course course = new Course(courseName, description, durationWeeks);	
		courseList.add(course);
		System.out.println(UITexts.COURSE_ADDED_SUCESS);
	}

	@Override
	public List<Course> displayAllCourse() {
		return courseList;
	}

	@Override
	public void activateDeactivateStudent(Scanner scan) {
		System.out.println("Please enter an ID :");
		int courseId = scan.nextInt();
		
		Course c = new Course();
		
		Optional<Course> item = courseList.stream()
		.filter(course -> course.getId()==courseId)
		.findFirst();
		
		if(item.isPresent()) {
		c= item.get();	
		}
		else {
			System.err.println(UITexts.COURSE_NOT_EXIST);
		}
		
		if(c.isActive()) {
			
			System.out.println("Shall we deactivate? Yes/No :");
			boolean active = scan.next().equalsIgnoreCase("Yes") ? false : c.isActive();
			c.setActive(active);

		}
		else {
			
			System.out.println("Shall we activate? Yes/No :");
			boolean active = scan.next().equalsIgnoreCase("Yes") ? true: c.isActive();
			c.setActive(active);

		}
	}

}
