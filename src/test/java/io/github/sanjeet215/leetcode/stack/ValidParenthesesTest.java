package io.github.sanjeet215.leetcode.stack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    static Stream<Arguments> cases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([])", true),
                Arguments.of("([)]", false),      // right types, wrong order
                // Edge cases
                Arguments.of("(", false),         // unclosed open bracket
                Arguments.of(")", false),         // close with nothing open
                Arguments.of("((", false),        // only opens
                Arguments.of("))", false),        // only closes
                Arguments.of("(){}}{", false),    // extra close in the middle
                Arguments.of("{[()()]}", true),   // deep nesting
                Arguments.of("[({})](", false),   // valid prefix, then leftover open
                Arguments.of("(()", false),       // open must be pushed even when stack is non-empty
                Arguments.of("(])", false),       // mismatched close must fail, not be ignored
                Arguments.of("(([]))", true));    // same-type nesting
    }

    @ParameterizedTest(name = "\"{0}\" -> {1}")
    @MethodSource("cases")
    void optimized(String s, boolean expected) {
        assertThat(solution.isValid(s)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "\"{0}\" -> {1}")
    @MethodSource("cases")
    void firstVersion(String s, boolean expected) {
        assertThat(solution.isValidFirstVersion(s)).isEqualTo(expected);
    }
}
