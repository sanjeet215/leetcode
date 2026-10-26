package io.github.sanjeet215.leetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidPalindromeTest {

    private final ValidPalindrome solution = new ValidPalindrome();

    @ParameterizedTest(name = "\"{0}\" -> {1}")
    @CsvSource(delimiter = '|', value = {
            // LeetCode examples
            "'A man, a plan, a canal: Panama' | true",
            "'race a car'                     | false",
            "' '                              | true",   // empty after filtering
            // Edge cases
            "'a'                              | true",   // single character
            "'.,'                             | true",   // only punctuation
            "'0P'                             | false",  // digit vs letter: '0' and 'p' differ
            "'ab_a'                           | true",   // underscore is not alphanumeric
            "'No lemon, no melon'             | true",   // mixed case
            "'12321'                          | true",   // digits count
            "'1a2'                            | false",
            "'abcba!'                         | true",   // trailing punctuation
    })
    void detectsPalindromes(String s, boolean expected) {
        assertThat(solution.isPalindrome(s)).isEqualTo(expected);
    }
}
