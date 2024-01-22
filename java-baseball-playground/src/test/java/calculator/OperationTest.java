package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperationTest {

    @ParameterizedTest(name = "{0}{1}{2} / 계산 / 결과: {3}")
    @CsvSource(
            {"6,+,2,8", "6,-,2,4", "6,*,2,12", "6,/,2,3"}
    )
    void validOperation(int a, String inputOperation, int b, int result) {
        assertThat(Operation.calculate(inputOperation, a, b)).isEqualTo(result);
    }

    @Test
    @DisplayName("유효하지않은 계산식 / 계산 / IllegalArgumentException")
    void invalidOperation() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operation.calculate("^", 1, 2));
    }
}