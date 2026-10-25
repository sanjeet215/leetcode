package io.github.sanjeet215.leetcode.twopointers;

/**
 * Merge two sorted arrays into a new array (the merge step of merge sort).
 * <p>
 * Pattern: two pointers, forward. Uses {@code <=} on ties so elements from {@code a} come first,
 * which keeps the merge stable.
 * <p>
 * Time: O(n + m). Space: O(n + m) for the result.
 */
public class MergeTwoSortedArrays {

    public int[] merge(int[] a, int[] b) {
        int[] r = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            r[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        }
        while (i < a.length) {
            r[k++] = a[i++];
        }
        while (j < b.length) {
            r[k++] = b[j++];
        }
        return r;
    }
}
