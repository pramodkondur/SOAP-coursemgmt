package com.pramo.soap.soapcoursemgmt.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pramo.soap.soapcoursemgmt.soap.bean.Course;

@Component
public class CourseDetailsService {
	public enum Status {
		SUCCESS, FAILURE;
	}

	private static List<Course> courses = new ArrayList<>();

	static {
		Course course1 = new Course(1, "Java", "Top methods to master");
		courses.add(course1);

		Course course2 = new Course(2, "Springboot", "Intro to Springboot");
		courses.add(course2);

		Course course3 = new Course(3, "Web development", "HTML, CSS, Javascript");
		courses.add(course3);

		Course course4 = new Course(4, "Maven", "Build tool introduction");
		courses.add(course4);
	}

	// course - 1
	public Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id)
				return course;
		}
		return null;
	}

	// courses
	public List<Course> findAll() {
		return courses;
	}

	public Status deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

}
