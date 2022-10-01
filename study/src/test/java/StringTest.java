import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("문자열에서 `,`를 구분자로 split 하기")
    @Test
    void test1() {
        assertThat("1".split(",")).containsExactly("1");
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("처음과 마지막 글자를 제외하기위해 substring을 사용하고 `,`로 split 하기")
    @Test
    void test2() {
        String testString = "(1,2)";
        int size = testString.length();
        assertThat(testString.substring(1, size-1).split(",")).containsExactly("1", "2");
    }

    @DisplayName("charAt을 통해 해당 인덱스에 있는 글자 가져오기")
    @Test
    void test3() {
        String testString = "abc";
        assertThat(testString.charAt(0)).isEqualTo('a');
        assertThat(testString.charAt(1)).isEqualTo('b');
        assertThat(testString.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            testString.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");

    }
}
