package calculator;

public class Calculator {
    public static final String SEPARATOR = " ";
    private String[] values;

    public Calculator(String inputStrings) {
        validateInputStrings(inputStrings);
        values = inputStrings.split(SEPARATOR);
    }

    public void validateInputStrings(String inputStrings) {
        if (inputStrings.split(SEPARATOR).length % 2 == 0) {
            throw new IllegalArgumentException(String.format("%s는 유효하지 않은 입력입니다.", inputStrings));
        }
    }

    public int calculateAll() {
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            Operation operation = Operation.of(values[i]);
            int nextNumber = Integer.parseInt(values[i + 1]);
            result = calculate(result, nextNumber, operation);
        }
        return result;
    }

    private int calculate(int a, int b, Operation operation) {
        if (operation == Operation.PLUS){
            return add(a, b);
        }
        if (operation == Operation.MINUS) {
            return minus(a, b);
        }
        if (operation == Operation.MULTIPLICATION) {
            return multiplication(a, b);
        }
        if (operation == Operation.DIVISION) {
            return division(a, b);
        }
        throw new IllegalArgumentException(String.format("%s은 지원하지 않는 연산기호입니다.", operation));
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiplication(int a, int b) {
        return a * b;
    }

    private int division(int a, int b) {
        return a / b;
    }
}
