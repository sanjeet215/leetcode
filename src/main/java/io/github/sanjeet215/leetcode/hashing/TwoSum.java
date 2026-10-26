package io.github.sanjeet215.leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 1 - Two Sum.
 * <p>
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers {@code nums} and an integer {@code target}, return the indices of
 * the two numbers that add up to {@code target}. Exactly one solution exists, and the same
 * element may not be used twice. The indices can be returned in any order.
 * <p>
 * Pattern: hashing (complement lookup). Key idea: for each {@code x}, the partner needed is
 * {@code target - x}. Store each value's index in a map and check for the complement before
 * inserting, so an element never pairs with itself and duplicates like {@code [3,3]} still work.
 * Brute force (check every pair) is O(n^2).
 * <p>
 * Time: O(n) - one pass, O(1) average map lookup. Space: O(n) for the map.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int integerToLookFor = target - nums[index];
            if (map.containsKey(integerToLookFor))
                return new int[]{map.get(integerToLookFor), index};
            map.put(nums[index], index);
        }
        return new int[]{-1, -1};
    }
}
