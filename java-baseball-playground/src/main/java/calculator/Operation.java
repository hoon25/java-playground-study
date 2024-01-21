package calculator;

public enum Operation {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    ;

    private final String label;

    Operation(String label) {
        this.label = label;
    }

    public static Operation of(String inputOperation) {
        Operation[] operations = Operation.values();
        for (Operation operation : operations) {
            if (operation.label.equals(inputOperation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(String.format("%s은 지원하지 않는 연산기호입니다.", inputOperation));
    }
}
