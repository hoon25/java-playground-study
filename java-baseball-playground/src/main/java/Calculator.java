public class Calculator {
    public CalculationSymbol symbol = CalculationSymbol.PLUS;
    public int getResult(String statement) {
        String[] values = statement.split(" ");

        int result = 0;

        for (String value: values) {
            result = this.calculate(result, value);
            this.setSymbol(value);
        }
        return result;
    }

    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private int calculate(int previous, String value){
        if (!this.isNumeric(value)) return previous;

        int addition = Integer.parseInt(value);
        if (symbol == CalculationSymbol.PLUS) previous += addition;
        if (symbol == CalculationSymbol.MINUS) previous -= addition;
        if (symbol == CalculationSymbol.MULTIPLY) previous *= addition;
        if (symbol == CalculationSymbol.DIVIDE) previous /= addition;
        return previous;
    }

    private void setSymbol(String value) {
        if(!CalculationSymbol.contains(value)) return;

        if (value.equals("+")) symbol = CalculationSymbol.PLUS;
        if (value.equals("-")) symbol = CalculationSymbol.MINUS;
        if (value.equals("*")) symbol = CalculationSymbol.MULTIPLY;
        if (value.equals("/")) symbol = CalculationSymbol.DIVIDE;
    }
}
