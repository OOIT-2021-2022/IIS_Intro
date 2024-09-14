package schoolWork;

public class Student extends SchoolMember {
	private double avgGrade;
	private Teacher classTeacher;

	public Student() {

	}

	public Student(String name, int age, double avgGrade) {
		super(name, age);
		this.avgGrade = avgGrade;
	}

	public String evaluateTheStudent(int grade) {
		return this.classTeacher.assignSubject() + " and student " + this.getName() + " got " + grade;
	}

	public String evaluateTheStudent(int grade, String note) {
		return this.evaluateTheStudent(grade) + " --> note: " + note; // moze postojati dve metode sa istim imenom ako
																		// imaju razlicit broj unosnih vrednosti, tj.
																		// razlicit broj parametra, ili po redosledu
																		// tipova podataka, zove se overloading
	}

	public Teacher getClassTeacher() {
		return this.classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	public double getAvgGrade() {
		return this.avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}

	public String toString() {
		return super.toString() + ", grade: " + this.avgGrade;
	}
}
