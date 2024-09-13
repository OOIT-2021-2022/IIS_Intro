package introduction;

public class Variables {

	public static void main(String[] args) {
		
		/* int i double
		int firstNumber = 5;
		double secondNumber = 2.4;
		double sum = firstNumber + secondNumber; int sum = (int) (firstNumber + secondNumer);
		System.out.println(sum);
		*/
		
		/* char i String
		char c = ' ';
		String firstName = "Ivan";
		String lastName = "Stankovic";
		String firstName2 = "Ivana";
		String lastName2 = "Ivanovic";
		
		// int x = firstName.length();
		
		/* concat
		String fullName = firstName + " " + lastName;
		String fullName2 = firstName2.concat(lastName2);
		System.out.println(fullName + "\n" + fullName2);
		String fullName3 = firstName.concat(" ").concat(lastName2);
		System.out.println(fullName3);
		*/
		
		/*  StringBuilder 
		StringBuilder sb = new StringBuilder();
		sb.append(firstName).append(" ").append(lastName);
		String fullName = sb.toString();
		System.out.println(fullName); 
		*/
		
		/* String.join
		String fullName = String.join(" ", firstName, lastName);
		System.out.println(fullName);
		*/
		
		/* if, else, else if
		int x = 2;
		if (x == 5) {
			System.out.println("x is 5");
		}
		else if (x == 4){
			System.out.println("x is 4");
		}
		else {
			System.out.println("x is not 4 or 5");
		}
		*/
		
		/* zadatak 1
		int a = 21;
		int b = 11;
		double result = 0;
		char operation = 's';
		
		if (operation == '+') {
			result = a + b;
		}
		else if (operation == '-') {
			if(a>b)
			result = a - b;
			else
			result = b - a;
		}
		else if (operation == '*') {
			result = a * b;
		}
		else if (operation == '/') {
			result = a / b;
		}
		else {
			System.out.println("error");
		}
		*/
		
		/* for
		for(int i = 0; i < 10; i++)
			System.out.println("Kvadrat broja " + i + " je: " + i*i);
		*/
		
		/*
		int i = 0;
		while (i < 10) {
			System.out.println("Kvadrat broja " + i + " je: " + i*i);
			i++;
		}
		*/
		
		/*
		int i = 0;
		do {
			System.out.println("Kvadrat broja " + i + " je: " + i*i);
			i++;
		} while (i > 10);
		*/
		
		/* zadatak 2
		int f = 5;
		int sumF = 1;
		while (f > 0) {
			sumF = sumF * f;
			f--;
		}
		System.out.println(sumF);
		*/
		
		 
	}

}
