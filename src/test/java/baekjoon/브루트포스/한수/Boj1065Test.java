package baekjoon.브루트포스.한수;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Boj1065Test {

    @ParameterizedTest
    @CsvSource(value = {"110, 99", "1, 1", "210, 105", "1000, 144"})
    void count한수(int n, int expected) {
        int actual = Boj1065.count한수(n);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "10, true", "99, true", "100, false", "111, true", "321, true"})
    void is한수(int n, boolean expected) {
        boolean actual = Boj1065.is한수(n);
        assertThat(actual).isEqualTo(expected);
    }
}