package io.github.sanjeet215.leetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumIITest {

    private final TwoSumII solution = new TwoSumII();

    // Expected indices are 1-indexed and ordered (index1 < index2), unlike LC 1.
    static Stream<Arguments> cases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2}),
                // Edge cases
                Arguments.of(new int[]{3, 3}, 6, new int[]{1, 2}),                    // equal values, minimum size
                Arguments.of(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8, new int[]{4, 5}), // duplicates in the middle
                Arguments.of(new int[]{-10, -3, 0, 5, 7}, -13, new int[]{1, 2}),      // both negative, at the start
                Arguments.of(new int[]{-8, -1, 0, 4, 9}, 1, new int[]{1, 5}),         // first + last
                Arguments.of(new int[]{1, 2, 5, 8, 13, 21}, 34, new int[]{5, 6}),     // pair at the end
                Arguments.of(new int[]{0, 0, 3, 4}, 0, new int[]{1, 2}));             // zeros
    }

    @ParameterizedTest
    @MethodSource("cases")
    void returnsOneIndexedOrderedPair(int[] numbers, int target, int[] expected) {
        assertThat(solution.twoSum(numbers, target)).containsExactly(expected);
    }
}
