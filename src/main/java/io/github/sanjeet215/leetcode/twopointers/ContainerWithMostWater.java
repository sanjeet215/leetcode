package io.github.sanjeet215.leetcode.twopointers;

/**
 * LC 11 - Container With Most Water.
 * <p>
 * https://leetcode.com/problems/container-with-most-water/
 * <p>
 * Given an array {@code height} of n non-negative integers, there are n vertical lines where line
 * {@code i} goes from {@code (i, 0)} to {@code (i, height[i])}. Find two lines that, together
 * with the x-axis, form a container holding the most water, and return that amount. The
 * container cannot be slanted. {@code height} has 2 to 100,000 elements, each in [0, 10,000].
 * <p>
 * Pattern: two pointers, converging from both ends. Key idea: start with the widest container.
 * Area is limited by the shorter line, and every inward move shrinks the width. So always move
 * the shorter line: keeping it, any container it forms with a line further in is narrower and
 * still capped at its height, so it can never beat the current area. Moving the taller line can
 * never help for the same reason. Brute force (every pair) is O(n^2).
 * <p>
 * Time: O(n) - each step moves one pointer inward. Space: O(1).
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = 0;

        while(leftIndex < rightIndex)
        {
            int currentArea = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex - leftIndex);
            maxArea = Math.max(maxArea, currentArea);
            if(height[leftIndex] < height[rightIndex])
            {
                leftIndex++;
            }
            else
            {
                rightIndex--;
            }
        }
        return maxArea;
    }
}
