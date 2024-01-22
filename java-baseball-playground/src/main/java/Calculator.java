public class Calculator {
    private CalculationSymbol symbol = CalculationSymbol.PLUS;
    private int result = 0;

    public int getResult(String statement) {
        String[] values = statement.split(" ");

        for (String value : values) {
            this.calculate(value);
            this.setSymbol(value);
        }

        return result;
    }

    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private void calculate(String value) {
        if (!this.isNumeric(value)) return;

        int addition = Integer.parseInt(value);
        if (symbol == CalculationSymbol.PLUS) result += addition;
        if (symbol == CalculationSymbol.MINUS) result -= addition;
        if (symbol == CalculationSymbol.MULTIPLY) result *= addition;
        if (symbol == CalculationSymbol.DIVIDE) result /= addition;
    }

    private void setSymbol(String value) {
        if (!CalculationSymbol.contains(value)) return;

        if (value.equals("+")) symbol = CalculationSymbol.PLUS;
        if (value.equals("-")) symbol = CalculationSymbol.MINUS;
        if (value.equals("*")) symbol = CalculationSymbol.MULTIPLY;
        if (value.equals("/")) symbol = CalculationSymbol.DIVIDE;
    }
}
