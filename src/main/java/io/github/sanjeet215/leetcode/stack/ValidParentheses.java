package io.github.sanjeet215.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * LC 20 - Valid Parentheses.
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Given a string {@code s} containing only the characters {@code ( ) { } [ ]}, return
 * {@code true} if it is valid: every open bracket is closed by the same type of bracket, open
 * brackets are closed in the correct order, and every close bracket has a matching open bracket.
 * {@code s} has 1 to 10,000 characters.
 * <p>
 * Pattern: stack. Key idea: the most recently opened bracket must be closed first (LIFO), so
 * keep unclosed brackets on a stack. Two ways to fail: a close bracket with no matching open
 * bracket on top, or open brackets left over at the end.
 * <p>
 * Time: O(n) - each character pushed and popped at most once. Space: O(n) - worst case all
 * open brackets, e.g. {@code "(((("}.
 */
public class ValidParentheses {

    /**
     * Optimized: fail-fast. Pushes the expected closing bracket for each open bracket, so a close
     * bracket only needs one comparison with {@code pop()}. Returns {@code false} as soon as a
     * close bracket has no match, and skips odd-length strings entirely. Uses {@link ArrayDeque}
     * instead of the legacy, synchronized {@link Stack}.
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false; // odd length can never balance
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')'); // push the closer we expect
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false; // close bracket with no opener, or the wrong type
            }
        }
        return stack.isEmpty(); // leftover openers were never closed
    }

    /**
     * First version: pushes every character that doesn't close the top of the stack. Correct
     * because a pushed close bracket can never be popped (pops only happen when an open bracket
     * is on top), so it guarantees a non-empty stack and {@code false} at the end. Slower to
     * fail: it always scans the whole string, and the invariant is implicit rather than explicit.
     */
    public boolean isValidFirstVersion(String s) {
        Stack<Character>  stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(stack.isEmpty())
            {
                stack.push(c);
            }
            else
            {
                if (stack.peek() == '(' && ')' == c || stack.peek() == '{' && '}' == c || stack.peek() == '[' && ']' == c)
                {
                    stack.pop();
                }
                else
                {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
