package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("1 1 2 2 / size / 3")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "{0} / contains / {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void contains(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }
}
