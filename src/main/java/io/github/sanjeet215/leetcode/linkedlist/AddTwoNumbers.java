package io.github.sanjeet215.leetcode.linkedlist;

import io.github.sanjeet215.leetcode.common.ListNode;

/**
 * LC 2 - Add Two Numbers.
 * <p>
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits
 * are stored in reverse order, and each node contains a single digit. Add the two numbers and
 * return the sum as a linked list, also in reverse order. The numbers have no leading zeros,
 * except the number 0 itself. Each list has 1 to 100 nodes.
 * <p>
 * Pattern: linked list traversal with a dummy head and a carry. Key idea: digits are stored
 * units-first, so add from the head like column addition on paper, carrying forward. Treat a
 * missing digit as 0 and keep looping while either list has digits or a carry is pending. The
 * dummy head avoids special-casing the first node of the result.
 * <p>
 * Converting each list to a number does not work: up to 100 digits overflows even {@code long}.
 * <p>
 * Time: O(max(m, n)) - each digit visited once. Space: O(1) extra; the output list itself is
 * O(max(m, n)) nodes.
 */
public class AddTwoNumbers {

    /**
     * First attempt: three loops (both lists, then each leftover tail) plus a final carry check.
     * Same complexity as {@link #addTwoNumbers}, but duplicates the add-carry logic and throws
     * NullPointerException if either input is empty (relies on LeetCode's non-empty guarantee).
     */
    public ListNode addTwoNumbersFirstVersion(ListNode l1, ListNode l2) {
        ListNode dummyHead = null;
        ListNode resultHead = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int listNodeVal1 = l1.val;
            int listNodeVal2 = l2.val;
            int sum = listNodeVal1 + listNodeVal2 + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            if (dummyHead == null) {
                dummyHead = new ListNode(remainder);
                resultHead = dummyHead;
            } else {
                dummyHead.next = new ListNode(remainder);
                dummyHead = dummyHead.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            dummyHead.next = new ListNode(remainder);
            dummyHead = dummyHead.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            dummyHead.next = new ListNode(remainder);
            dummyHead = dummyHead.next;
            l2 = l2.next;
        }

        if (carry != 0)
            dummyHead.next = new ListNode(carry);
        return resultHead;
    }

    /** Optimal: a single loop that handles unequal lengths and the final carry uniformly. */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        return dummy.next;
    }
}
