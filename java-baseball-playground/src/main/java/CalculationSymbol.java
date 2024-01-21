import java.util.Arrays;

public enum CalculationSymbol {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String description;

    public static void validate(String value) {
        if(CalculationSymbol.contains(value)) return;
        throw new RuntimeException("잘못된 문자가 사칙연산 기호로 입력되었습니다.");
    }

    public static boolean contains(String value) {
        return Arrays.stream(values())
                .anyMatch(enumValue -> enumValue.description.equals(value));
    }

    CalculationSymbol(String description) { this.description = description; }

    public String getDescription() { return description; }
}
