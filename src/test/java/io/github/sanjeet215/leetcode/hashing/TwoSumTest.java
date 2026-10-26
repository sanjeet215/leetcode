package io.github.sanjeet215.leetcode.hashing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumTest {

    private final TwoSum solution = new TwoSum();

    static Stream<Arguments> cases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),          // must not reuse 3 with itself
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),             // duplicate values
                // Edge cases
                Arguments.of(new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2}),     // negatives
                Arguments.of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3}),       // zeros
                Arguments.of(new int[]{1, 5, 9, 2}, 11, new int[]{2, 3}));     // pair at the end
    }

    @ParameterizedTest
    @MethodSource("cases")
    void returnsIndicesOfPairSummingToTarget(int[] nums, int target, int[] expected) {
        // Order of the two indices doesn't matter per the problem statement.
        assertThat(solution.twoSum(nums, target)).containsExactlyInAnyOrder(expected);
    }
}
