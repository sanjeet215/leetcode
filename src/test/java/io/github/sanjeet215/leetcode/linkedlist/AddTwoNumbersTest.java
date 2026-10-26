package io.github.sanjeet215.leetcode.linkedlist;

import static io.github.sanjeet215.leetcode.common.ListNodes.of;
import static io.github.sanjeet215.leetcode.common.ListNodes.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoNumbersTest {

    private final AddTwoNumbers solution = new AddTwoNumbers();

    // Digits are in reverse order: [2,4,3] is 342.
    static Stream<Arguments> cases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}),          // 342 + 465 = 807
                Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9},
                        new int[]{8, 9, 9, 9, 0, 0, 0, 1}),
                // Edge cases
                Arguments.of(new int[]{5}, new int[]{5}, new int[]{0, 1}),                         // final carry adds a node
                Arguments.of(new int[]{1, 8}, new int[]{0}, new int[]{1, 8}),                      // different lengths
                Arguments.of(new int[]{0}, new int[]{7, 3}, new int[]{7, 3}),                      // shorter list first
                Arguments.of(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                        new int[]{1},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}));   // overflows long
    }

    @ParameterizedTest
    @MethodSource("cases")
    void singleLoop(int[] a, int[] b, int[] expected) {
        assertThat(toList(solution.addTwoNumbers(of(a), of(b)))).containsExactly(boxed(expected));
    }

    @ParameterizedTest
    @MethodSource("cases")
    void firstVersion(int[] a, int[] b, int[] expected) {
        assertThat(toList(solution.addTwoNumbersFirstVersion(of(a), of(b)))).containsExactly(boxed(expected));
    }

    private static Integer[] boxed(int[] values) {
        return Arrays.stream(values).boxed().toArray(Integer[]::new);
    }
}
