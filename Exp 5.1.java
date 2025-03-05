//Write a Java program to calculate the sum of a list of integers using autoboxing and unboxing. Include methods to parse strings into their respective wrapper classes (e.g., Integer.parseInt()).

//CODE:

import java.util.ArrayList;

import java.util.List;



public class fifth {

    public static int calculateSum(List<Integer> numbers) {

        int sum = 0;

        for (Integer number : numbers) {

            sum += number; // Unboxing occurs here automatically

        }

        return sum;

    }

    public static Integer parseInteger(String str) {

        return Integer.parseInt(str);

    }

    public static void main(String[] args) {

        String[] numberStrings = {"10", "20", "30", "40", "50"};

        List<Integer> numberList = new ArrayList<>();

        for (String numStr : numberStrings) {

            numberList.add(parseInteger(numStr)); // Autoboxing occurs here

        }

        int totalSum = calculateSum(numberList);

        System.out.println("The sum of the integers is: " + totalSum);

    }

}
