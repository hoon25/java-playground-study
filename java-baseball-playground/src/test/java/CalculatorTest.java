import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        int result = calculator.getResult("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}