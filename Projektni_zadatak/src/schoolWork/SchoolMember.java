package schoolWork;

public class SchoolMember {
	private String name;
	protected int age;

	public SchoolMember() {

	}

	public SchoolMember(String name) {
		this.name = name;
	}

	public SchoolMember(int age) {
		this.age = age;
	}

	public SchoolMember(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Person: " + this.name + ", age: " + this.age;
	}

}
