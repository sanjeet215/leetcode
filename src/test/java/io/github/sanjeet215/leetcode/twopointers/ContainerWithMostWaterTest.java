package io.github.sanjeet215.leetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater solution = new ContainerWithMostWater();

    // Area = min(height[i], height[j]) * (j - i)
    static Stream<Arguments> cases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),   // lines at 1 and 8: min(8,7) * 7
                Arguments.of(new int[]{1, 1}, 1),                          // minimum size
                // Edge cases
                Arguments.of(new int[]{0, 0}, 0),                          // zero height
                Arguments.of(new int[]{4, 3, 2, 1, 4}, 16),                // widest pair is best
                Arguments.of(new int[]{10, 1, 1, 1, 10}, 40),              // tall ends, low middle
                Arguments.of(new int[]{1, 2, 1}, 2),
                Arguments.of(new int[]{1, 2, 4, 3}, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 6),                 // strictly increasing
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 6),                 // strictly decreasing
                Arguments.of(new int[]{2, 3, 4, 5, 18, 17, 6}, 17),        // two tallest adjacent: width 1
                Arguments.of(new int[]{1, 3, 2, 5, 25, 24, 5}, 24));       // tallest pair beats wider pairs
    }

    @ParameterizedTest
    @MethodSource("cases")
    void returnsMaxArea(int[] height, int expected) {
        assertThat(solution.maxArea(height)).isEqualTo(expected);
    }
}
