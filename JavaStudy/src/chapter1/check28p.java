package chapter1;

import java.util.ArrayList;

public class check28p {

	public static void main(String[] args) {
		Student2 st2 = new Student2("cjy");
		Course c1 = new Course("algorithm");
		Course c2 = new Course("dataSturucture");
		
		st2.registerCourse(c1);
		st2.registerCourse(c2);
		
		System.out.println(st2.getCourses().iterator());
		
		
		for(Course course : st2.getCourses()) {
			System.out.println(course.getName());
		}

	}

}
class Student2 {
	private String name;
	private ArrayList<Course> courses;
	
	public Student2(String name) {
		this.name=name;
		courses = new ArrayList<Course>();
	}
	
	public void registerCourse(Course course) {
		courses.add(course);
	}
	
	public void dropCourse(Course course) {
		if(courses.contains(course)) {
			courses.remove(course);
		}
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
}

class Course {
	private String name;
	
	public Course(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}