import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("원하는 문자열을 입력하세요!");
        Scanner scanner = new Scanner(System.in);
        String statement = scanner.nextLine();
        scanner.close();

        Calculator calculator = new Calculator();

        int result =  calculator.getResult(statement);

        System.out.println(result);
    }
}
