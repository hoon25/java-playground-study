package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    @DisplayName("계산식 / 계산 / 성공")
    void calculateAll() {
        Calculator calculator = new Calculator("2 + 3 * 4 / 2");

        assertThat(calculator.calculateAll()).isEqualTo(10);
    }

    @Test
    @DisplayName("유효하지않은 계산식 / 계산 / IllegalArgumentException")
    void invalidInputString() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator("6 *"));
    }
}