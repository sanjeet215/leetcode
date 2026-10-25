package io.github.sanjeet215.leetcode.slidingwindow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestSubstringKDistinctTest {

    private final LongestSubstringKDistinct solution = new LongestSubstringKDistinct();

    @ParameterizedTest(name = "s=\"{0}\", k={1} -> {2}")
    @CsvSource({
            "eceba,  2, 3",
            "aa,     1, 2",
            "abaccc, 2, 4",  // reset-to-zero bug would return 3
            "abc,    0, 0",
            "'',     2, 0",
            "abc,    5, 3",  // k larger than distinct count
            "aaaa,   1, 4",
    })
    void returnsLongestWindow(String s, int k, int expected) {
        assertThat(solution.lengthOfLongestSubstringKDistinct(s, k)).isEqualTo(expected);
    }
}
