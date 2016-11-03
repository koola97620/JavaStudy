package chapter1;

// 27쪽 그림 1-9를 코드로 작성하라.

public class Design01 {
	
	public static void main(String[] args) {
		Professor pro = new Professor();
		Student stu = new Student();
		
		pro.setStudent(stu);
		pro.advise();

	}

}

class Professor {
	private Student student;
	
	public void setStudent(Student student) {
		this.student = student;
		student.setAdvisor(this);
		
	}
	public void advise() {
		student.advise(this.getClass().getName() + " 상담내용임");
	}
	
	
}

class Student {
	private Professor advisor;
	
	public void setAdvisor(Professor professor) {
		this.advisor = professor;
	}
	
	public void advise(String msg) {
		System.out.println(msg);
	}
}