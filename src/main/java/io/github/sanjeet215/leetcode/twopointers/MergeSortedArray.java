package io.github.sanjeet215.leetcode.twopointers;

/**
 * LC 88 - Merge Sorted Array (in place).
 * <p>
 * https://leetcode.com/problems/merge-sorted-array/
 * <p>
 * Pattern: two pointers, backward. The free space is at the end of {@code nums1}, so filling
 * from the back never overwrites an unread value. If {@code nums2} runs out first, the remaining
 * {@code nums1} values are already in place. Strict {@code >} on ties keeps the merge stable.
 * <p>
 * Time: O(m + n). Space: O(1).
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
