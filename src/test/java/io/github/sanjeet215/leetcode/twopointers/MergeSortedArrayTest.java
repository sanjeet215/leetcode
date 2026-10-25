package io.github.sanjeet215.leetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeSortedArrayTest {

    private final MergeSortedArray solution = new MergeSortedArray();

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{0, 0}, 0, new int[]{1, 2}, new int[]{1, 2}),          // m = 0
                Arguments.of(new int[]{1}, 1, new int[]{}, new int[]{1}),                    // n = 0
                Arguments.of(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{2, 2, 0, 0}, 2, new int[]{2, 2}, new int[]{2, 2, 2, 2}));
    }

    @ParameterizedTest
    @MethodSource("cases")
    void mergesInPlace(int[] nums1, int m, int[] nums2, int[] expected) {
        solution.merge(nums1, m, nums2, nums2.length);
        assertThat(nums1).containsExactly(expected);
    }
}
