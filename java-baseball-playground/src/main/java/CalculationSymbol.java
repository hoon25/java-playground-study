import java.util.Arrays;

public enum CalculationSymbol {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String description;


    public static boolean contains(String value) {
        return Arrays.stream(values())
                .anyMatch(enumValue -> enumValue.description.equals(value));
    }

    CalculationSymbol(String description) { this.description = description; }
}
