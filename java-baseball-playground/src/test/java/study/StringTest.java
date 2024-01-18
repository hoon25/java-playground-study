package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}































