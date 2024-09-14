package schoolWork;

public class Teacher extends SchoolMember {
	private int salary;
	private String subject;

	public Teacher() {

	}

	public Teacher(String name, int age, int salary) {
		super(name, age);
		this.salary = salary;

	}

	public Teacher(String name, int age, int salary, String subject) {
		super(name, salary);
		this.age = age;
		this.subject = subject;
	}

	public String assignSubject() {
		return "Subject " + this.subject + " was assigned to the teacher " + this.getName();
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String toString() {
		return super.toString() + ", salary: " + this.salary;
	}

}
