package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스 테스트")
public class StringTest {
    @Test
    @DisplayName("String 클래스 replace 메소드 테스트")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("String 클래스 split 메소드 테스트")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");

        String[] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    @DisplayName("String 클래스 substring 메소드 테스트")
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스 charAt 메소드 테스트")
    void charAt() {
        Character actual = "(1,2)".charAt(0);
        assertThat(actual).isEqualTo('(');

        assertThatThrownBy(() -> {
            "(1,2)".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 5");
    }

    @Test
    @DisplayName("String 클래스 사친 연산 계산기 테스트")
    void calculate() {
        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        String statement = scanner.nextLine();

        String[] values = statement.split(" ");

        Integer result = 0;
        String calculation = "+";
        for (Integer i = 0; i < values.length; i++){
            if (i % 2 == 1) {
                calculation = values[i];
                continue;
            }
            if (i % 2 == 0) {
                if (calculation.equals("+")) result += Integer.valueOf(values[i]);
                if (calculation.equals("-")) result -= Integer.valueOf(values[i]);
                if (calculation.equals("*")) result *= Integer.valueOf(values[i]);
                if (calculation.equals("/")) result /= Integer.valueOf(values[i]);
            }
        }

        assertThat(result).isEqualTo(10);
        scanner.close();
    }
}































