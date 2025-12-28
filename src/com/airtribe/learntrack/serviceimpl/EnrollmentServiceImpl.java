package com.airtribe.learntrack.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.utils.Status;

public class EnrollmentServiceImpl implements EnrollmentService{
	
	List<Enrollment> enrollmentList = new ArrayList<Enrollment>();
	
	StudentService studentService = new StudentServiceImpl();
	
	CourseService courseService = new CourseServiceImpl();


	@Override
	public void enrollStudent(Scanner scan) {
		Student std = getStudent(scan);
		
		Course course = getCourse(scan);
		
		enrollmentList.add(new Enrollment(std, course, LocalDate.now()));

	}

	private Course getCourse(Scanner scan) {

		System.out.println("Please enter the Course Id : ");
		try {
		int courseId = scan.nextInt();
		
		Optional<Course> courseToEnrolll = courseService.displayAllCourse()
		.stream()
		.filter(std -> std.getId()==courseId)
		.findFirst();
		
		if(courseToEnrolll.isPresent() && courseToEnrolll.get().isActive()) {
			return courseToEnrolll.get();
		}
		else {
			System.out.println("Course did not Found or inactive!");
		}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return null;		
	
	}

	public Student getStudent(Scanner scan) {
		System.out.println("Please enter the student Id : ");
		try {
		int studentId = scan.nextInt();
		
		Optional<Student> studentToEnroll = studentService.displayAllStudent()
		.stream()
		.filter(std -> std.getId()==studentId)
		.findFirst();
		
		if(studentToEnroll.isPresent() && studentToEnroll.get().isActive()) {
			return studentToEnroll.get();
		}
		else {
			System.out.println("Student did not Found or inactive!");
		}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return null;		
	}
	
	@Override
	public List<Enrollment> displayEnrollment() {
		return enrollmentList;
	}

	@Override
	public void updateEnrollment(Scanner scan) {
		
		System.out.println("Select Relevant Enrollment Id :");
		try {
			int nextInt= scan.nextInt();
			
		Optional<Enrollment> enrollmentOption = enrollmentList.stream().
		filter(a->a.getId()==nextInt)
		.findFirst();
		
		if(enrollmentOption.isPresent()) {
			Enrollment enrollment = enrollmentOption.get();
			System.out.println("CANCEL or COMPLETE?");
			String updatedInput = scan.nextLine();
			Status updatedStatus = updatedInput.startsWith("CA")? Status.CANCELLED:Status.COMPLETED;
			enrollment.setStatus(updatedStatus);
			System.out.println("UPDATED SUCCESSFULLY...!!");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Do you need to ");
		
	}

}
