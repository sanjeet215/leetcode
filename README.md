# leetcode-java

LeetCode / DSA interview prep in Java 21, organized by pattern, every solution backed by JUnit 5 tests.

## Run

```bash
mvn test                                     # all tests
mvn test -Dtest=TwoSumTest         # one class
```

## Layout

```
src/main/java/io/github/sanjeet215/leetcode/<pattern>/<ProblemName>.java
src/test/java/io/github/sanjeet215/leetcode/<pattern>/<ProblemName>Test.java
```

Packages are patterns, not difficulty, because interviews test pattern recognition:
`hashing`, `linkedlist`, `slidingwindow`, `stack`, `twopointers`, `binarysearch`, `intervals`, `heap`, `monotonicstack`,
`graph`, `tree`, `backtracking`, `dp`, `trie`, `unionfind`.

## Conventions for each new problem

1. **Class name** = problem title in PascalCase (`TwoSum`), method signature matches LeetCode.
2. **Javadoc header**: LC number + title, link, pattern, one-line key idea, time/space complexity.
3. **Test class** with a `@ParameterizedTest` covering: the LeetCode examples, empty / single-element
   input, duplicates, and the edge case you got wrong the first time (comment it).
4. Multiple approaches? Keep them as separate methods (`bruteForce`, `optimal`) and run the same
   test cases against both.

Template:

```java
/**
 * LC ### - Title.
 * <p>
 * https://leetcode.com/problems/slug/
 * <p>
 * Pattern: ... Key idea: ...
 * <p>
 * Time: O(...). Space: O(...).
 */
public class ProblemName {
    public int solve(...) { ... }
}
```

## Progress

| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 1 | [Two Sum](src/main/java/io/github/sanjeet215/leetcode/hashing/TwoSum.java) | Hashing | Easy |
| 2 | [Add Two Numbers](src/main/java/io/github/sanjeet215/leetcode/linkedlist/AddTwoNumbers.java) | Linked list | Medium |
| 167 | [Two Sum II - Input Array Is Sorted](src/main/java/io/github/sanjeet215/leetcode/twopointers/TwoSumII.java) | Two pointers | Medium |
| 125 | [Valid Palindrome](src/main/java/io/github/sanjeet215/leetcode/twopointers/ValidPalindrome.java) | Two pointers | Easy |
| 20 | [Valid Parentheses](src/main/java/io/github/sanjeet215/leetcode/stack/ValidParentheses.java) | Stack | Easy |
