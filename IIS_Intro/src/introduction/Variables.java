package introduction;

public class Variables {

	public static void main(String[] args) {

		/*
		 * double firstNumber; // deklaracija firstNumber = 1; // inicijalizacija
		 * System.out.println(firstNumber);
		 * 
		 * double secondNumber = 5;
		 * 
		 * double doubleResult = firstNumber / secondNumber;
		 * System.out.println(doubleResult);
		 * 
		 * int result = (int) (firstNumber / secondNumber); System.out.println(result);
		 * 
		 * boolean alwaysTrue = true; boolean secondBoolean = false;
		 * System.out.println(alwaysTrue && secondBoolean);
		 * System.out.println(alwaysTrue || secondBoolean);
		 * System.out.println(!alwaysTrue);
		 * 
		 * String name = "Petar"; String surName = "Petrovic"; System.out.println(name +
		 * " " + surName + " " + "Njegos");
		 */

		/*
		 * if (firstNumber > 0) System.out.println("Number is positive"); else if
		 * (firstNumber < 0) System.out.println("Number is negative"); else
		 * System.out.println("Number is equal to 0");
		 */

		/*
		 * int i = 1; while (i <= 10) { System.out.println(i); i++; }
		 */
		for (int i = 0; i <= 10; i++) {

			if (i % 2 == 1)
				System.out.println(i);
		}

		int x = 24;
		int y = 12;
		int result;

		String operation;
		operation = "plus";

		if (operation == "plus") {
			result = x + y;
			System.out.println(result);
		} else if (operation == "minus") {
			result = x - y;
			System.out.println(result);
		} else if (operation == "puta") {
			result = x * y;
			System.out.println(result);
		} else if (operation == "podeljeno") {
			result = x / y;
		System.out.println(result);
		} else {
			System.out.println("error");
		}

	}

}
