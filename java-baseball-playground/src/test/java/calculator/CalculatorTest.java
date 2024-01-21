package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    void invalidInputString() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator("6 *"));
    }

    @Test
    @DisplayName("나머지가 남는 나눗셈 / 나눈다 / IllegalArgumentException")
    void invalidDivision() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator("6 / 4").calculateAll());
    }
}