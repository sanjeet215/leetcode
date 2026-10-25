package io.github.sanjeet215.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 340 - Longest Substring with At Most K Distinct Characters.
 * <p>
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 * Pattern: variable sliding window. Expand {@code right}; while the window has more than
 * {@code k} distinct characters, shrink from {@code left}. Counts (not a set) tell us when a
 * character fully leaves the window.
 * <p>
 * Time: O(n) - each index enters and leaves the window at most once. Space: O(k).
 */
public class LongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k <= 0) {
            return 0;
        }
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int best = 0;
        for (int right = 0; right < s.length(); right++) {
            count.merge(s.charAt(right), 1, Integer::sum);
            while (count.size() > k) {
                char out = s.charAt(left++);
                if (count.merge(out, -1, Integer::sum) == 0) {
                    count.remove(out);
                }
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
