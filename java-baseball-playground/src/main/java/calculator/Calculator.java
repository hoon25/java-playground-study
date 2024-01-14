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
            String operation = values[i];
            int b = Integer.parseInt(values[i + 1]);

            if (operation.equals("+")) {
                result = add(result, b);
                continue;
            }
            if (operation.equals("-")) {
                result = minus(result, b);
                continue;
            }
            if (operation.equals("*")) {
                result = multiplication(result, b);
                continue;
            }
            if (operation.equals("/")) {
                result = division(result, b);
                continue;
            }
            throw new IllegalArgumentException(String.format("%s은 지원하지 않는 연산기호입니다.", operation));
        }
        return result;
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
