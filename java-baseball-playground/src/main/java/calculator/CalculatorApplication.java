package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStrings = scanner.nextLine();

        Calculator calculator = new Calculator(inputStrings);

        System.out.println(calculator.calculateAll());
    }
}
