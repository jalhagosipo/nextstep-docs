import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("size()를 활용해 set 크기를 확인하기")
    @Test
    void test1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 안에 들어있는 값 확인하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set 안에 다른 값이 들어있는 건 아닌지 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void test3(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
