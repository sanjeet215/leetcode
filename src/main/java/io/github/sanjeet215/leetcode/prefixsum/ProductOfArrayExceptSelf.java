package io.github.sanjeet215.leetcode.prefixsum;

import java.util.Arrays;

/**
 * LC 238 - Product of Array Except Self.
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/
 * <p>
 * Given an integer array {@code nums}, return an array {@code answer} where {@code answer[i]} is
 * the product of all elements of {@code nums} except {@code nums[i]}. The product of any prefix
 * or suffix fits in a 32-bit int. You must run in O(n) time and must NOT use division.
 * {@code nums} has 2 to 100,000 elements, each in [-30, 30].
 * <p>
 * Follow-up: solve it in O(1) extra space (the output array does not count).
 * <p>
 * Pattern: TODO. Key idea: TODO.
 * <p>
 * Time: O(?). Space: O(?).
 */
public class ProductOfArrayExceptSelf {

    //{1, 2, 3, 4}
    //{24, 12, 8, 6}
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // left[i] = product of everything before i
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // right[i] = product of everything after i
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // answer[i] = left side × right side
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }
}
