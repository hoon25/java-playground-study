package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("replace test")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split test")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring test")
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc / index3 charAt / c")
    void charAtSuccess() {
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("abc / index4 charAt / IndexOutOfBoundsException")
    void charAtFail() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
