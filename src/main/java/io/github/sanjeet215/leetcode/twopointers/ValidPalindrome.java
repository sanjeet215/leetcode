package io.github.sanjeet215.leetcode.twopointers;

/**
 * LC 125 - Valid Palindrome.
 * <p>
 * https://leetcode.com/problems/valid-palindrome/
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters to lowercase and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Letters and digits
 * are both alphanumeric. Given a string {@code s}, return {@code true} if it is a palindrome.
 * {@code s} has 1 to 200,000 printable ASCII characters.
 * <p>
 * Pattern: two pointers, converging from both ends. Key idea: instead of building a cleaned
 * copy, each pointer skips non-alphanumeric characters as it moves, and the two characters are
 * compared case-insensitively with {@link Character#toLowerCase(char)}.
 * <p>
 * Time: O(n) - each character is visited at most once. Space: O(n) because of
 * {@code toCharArray()}; reading with {@code s.charAt(i)} instead makes it O(1).
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        boolean isPalindrome = true;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right)
        {
            if(!Character.isLetterOrDigit(chars[left]))
            {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(chars[right]))
            {
                right--;
                continue;
            }

            char leftChar = Character.toLowerCase(chars[left]);
            char rightChar = Character.toLowerCase(chars[right]);
            if(leftChar != rightChar)
            {
                isPalindrome = false;
                break;
            }
            left++; right--;
        }
        return isPalindrome;
    }
}
