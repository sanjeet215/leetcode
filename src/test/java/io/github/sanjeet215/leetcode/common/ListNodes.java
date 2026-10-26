package io.github.sanjeet215.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/** Test helpers for building and reading linked lists. */
public final class ListNodes {

    private ListNodes() {
    }

    /** Builds a list from values in order; returns {@code null} for no values. */
    public static ListNode of(int... values) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int v : values) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    /** Reads a list into a {@code List<Integer>} for easy assertions. */
    public static List<Integer> toList(ListNode head) {
        List<Integer> out = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            out.add(n.val);
        }
        return out;
    }
}
