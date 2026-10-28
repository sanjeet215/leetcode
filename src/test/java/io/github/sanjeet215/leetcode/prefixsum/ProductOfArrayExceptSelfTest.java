package io.github.sanjeet215.leetcode.prefixsum;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductOfArrayExceptSelfTest {

    private final ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

    static Stream<Arguments> cases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}),   // one zero
                // Edge cases
                Arguments.of(new int[]{2, 3}, new int[]{3, 2}),                       // minimum size
                Arguments.of(new int[]{0, 4, 5}, new int[]{20, 0, 0}),                // zero at the start
                Arguments.of(new int[]{0, 0}, new int[]{0, 0}),                       // two zeros: all zero
                Arguments.of(new int[]{5, 0, 2, 0}, new int[]{0, 0, 0, 0}),           // two zeros, not adjacent
                Arguments.of(new int[]{-2, -3, 4}, new int[]{-12, -8, 6}),            // negatives
                Arguments.of(new int[]{1, 1, 1}, new int[]{1, 1, 1}),
                Arguments.of(new int[]{2, 2, 2, 2}, new int[]{8, 8, 8, 8}));
    }

    @ParameterizedTest
    @MethodSource("cases")
    void returnsProductOfAllOtherElements(int[] nums, int[] expected) {
        int[] original = nums.clone();
        assertThat(solution.productExceptSelf(nums)).containsExactly(expected);
        assertThat(nums).as("input must not be modified").containsExactly(original);
    }
}
