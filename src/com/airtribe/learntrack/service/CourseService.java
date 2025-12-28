package com.airtribe.learntrack.service;

import java.util.List;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;

public interface CourseService {
	

	void addCourse(Scanner scan);
	List<Course> displayAllCourse();
	void activateDeactivateStudent(Scanner scan);

}
