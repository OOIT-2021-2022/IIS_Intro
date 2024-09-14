package schoolWork;

public class WorkingDays {

	public static void main(String[] args) {
		Student student1 = new Student("Ivan", 22, 4.2);
		Teacher teacher1 = new Teacher("Milos", 41, 50000, "object-oriented programming");
		
		System.out.println(student1 + "\n" + teacher1);
		System.out.println(teacher1.assignSubject());
		
		student1.setClassTeacher(teacher1);
		
		student1.getClassTeacher().setSubject("web programming");
		System.out.println(student1.getClassTeacher().getSubject());
		System.out.println(teacher1.getSubject());
		System.out.println(student1.getClassTeacher().assignSubject());
		
		System.out.println(student1.evaluateTheStudent(5));
		System.out.println(student1.evaluateTheStudent(2, "grade needs to improve."));
	}

}
