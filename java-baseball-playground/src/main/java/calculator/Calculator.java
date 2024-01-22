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
            result = Operation.calculate(values[i], result, Integer.parseInt(values[i + 1]));
        }
        return result;
    }
}
