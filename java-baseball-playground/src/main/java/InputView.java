import java.util.Scanner;

public class InputView {
    public static String getInput() {
        System.out.print("숫자를 입력주세요: ");
        Scanner scanner = new Scanner(System.in);
        String statement = scanner.next();

        return statement;
    }

    public static Integer getChecker() {
        Scanner scanner = new Scanner(System.in);
        String statement = scanner.next();

        return Integer.valueOf(statement);
    }
}
