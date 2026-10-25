package io.github.sanjeet215.leetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeTwoSortedArraysTest {

    private final MergeTwoSortedArrays solution = new MergeTwoSortedArrays();

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5}, new int[]{2, 4, 6}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{}, new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2}, new int[]{}, new int[]{1, 2}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{1, 2, 2}, new int[]{2, 3}, new int[]{1, 2, 2, 2, 3}),
                Arguments.of(new int[]{7, 8}, new int[]{1, 2, 3}, new int[]{1, 2, 3, 7, 8}));
    }

    @ParameterizedTest
    @MethodSource("cases")
    void mergesIntoSortedArray(int[] a, int[] b, int[] expected) {
        assertThat(solution.merge(a, b)).containsExactly(expected);
    }
}
