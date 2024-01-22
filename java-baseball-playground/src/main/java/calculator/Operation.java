package calculator;

import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b),
    ;

    private final String label;
    private final BiFunction<Integer, Integer, Integer> calculate;

    Operation(String label, BiFunction<Integer, Integer, Integer> calculate) {
        this.label = label;
        this.calculate = calculate;
    }

    private static Operation of(String inputOperation) {
        Operation[] operations = Operation.values();
        for (Operation operation : operations) {
            if (operation.label.equals(inputOperation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(String.format("%s은 지원하지 않는 연산기호입니다.", inputOperation));
    }

    public static int calculate(String inputOperation, int a, int b) {
        return Operation.of(inputOperation).calculate.apply(a, b);
    }
}
