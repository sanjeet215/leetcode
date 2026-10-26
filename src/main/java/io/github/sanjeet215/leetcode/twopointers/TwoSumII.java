package io.github.sanjeet215.leetcode.twopointers;

/**
 * LC 167 - Two Sum II - Input Array Is Sorted.
 * <p>
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * Given a 1-indexed array of integers {@code numbers} sorted in non-decreasing order, find two
 * numbers that add up to {@code target}. Return their indices as {@code [index1, index2]},
 * 1-indexed, with {@code index1 < index2}. Exactly one solution exists, the same element may not
 * be used twice, and the solution must use only constant extra space.
 * <p>
 * Pattern: two pointers, converging from both ends. Key idea: because the array is sorted,
 * the sum of the two ends tells us which pointer to move. Too small: only a larger left value
 * can help, so move left right. Too big: only a smaller right value can help, so move right left.
 * Each move safely discards a value that cannot be part of the answer.
 * <p>
 * Why not the LC 1 hash map: it works, but uses O(n) extra space, and this problem requires O(1).
 * <p>
 * Time: O(n) - each step moves one pointer inward, at most n - 1 steps. Space: O(1).
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        // Defaults to [0, 0] if no pair exists; LeetCode guarantees one does.
        int[] result = new int[2];
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex)
        {
            // Values are in [-1000, 1000] per the constraints, so the sum cannot overflow int.
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if(sum == target)
            {
                // +1 because the problem uses 1-based indices.
                result = new int[]{leftIndex + 1, rightIndex + 1};
                break;
            }
            else if(sum < target)
            {
                // numbers[leftIndex] can't pair with anything: even the largest partner is too small.
                leftIndex++;
            }
            else
            {
                // numbers[rightIndex] can't pair with anything: even the smallest partner is too big.
                rightIndex--;
            }
        }
        return result;
    }
}
