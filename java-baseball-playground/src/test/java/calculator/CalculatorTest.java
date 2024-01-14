package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void plus() {
        Calculator calculator = new Calculator("6 + 2");

        assertThat(calculator.calculateAll()).isEqualTo(8);
    }

    @Test
    void minus() {
        Calculator calculator = new Calculator("6 - 2");

        assertThat(calculator.calculateAll()).isEqualTo(4);
    }

    @Test
    void multiplication() {
        Calculator calculator = new Calculator("6 * 2");

        assertThat(calculator.calculateAll()).isEqualTo(12);
    }

    @Test
    void division() {
        Calculator calculator = new Calculator("6 / 2");

        assertThat(calculator.calculateAll()).isEqualTo(3);
    }
}