package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperationTest {

    @ParameterizedTest
    @CsvSource(
            {"+, PLUS", "-, MINUS", "*, MULTIPLICATION", "/, DIVISION"}
    )
    void validOperation(String inputOperation, Operation operation) {
        assertThat(Operation.of(inputOperation)).isEqualTo(operation);
    }

    @Test
    @DisplayName("유효하지않은 연산기호 / 생성 / IllegalArgumentException")
    void invalidOperation() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operation.of("^"));
    }
}