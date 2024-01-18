public class Calculator {
    public int calculate(String statement) {
        String[] values = statement.split(" ");

        int result = 0;
        String calculation = "+";
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 1) {
                calculation = values[i];
                continue;
            }
            if (i % 2 == 0) {
                if (calculation.equals("+")) result += Integer.parseInt(values[i]);
                if (calculation.equals("-")) result -= Integer.parseInt(values[i]);
                if (calculation.equals("*")) result *= Integer.parseInt(values[i]);
                if (calculation.equals("/")) result /= Integer.parseInt(values[i]);
            }
        }

        return result;
    }
}
