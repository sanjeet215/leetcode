# leetcode-java

LeetCode / DSA interview prep in Java 21, organized by pattern, every solution backed by JUnit 5 tests.

## Run

```bash
mvn test                                     # all tests
mvn test -Dtest=MergeSortedArrayTest         # one class
```

## Layout

```
src/main/java/io/github/sanjeet215/leetcode/<pattern>/<ProblemName>.java
src/test/java/io/github/sanjeet215/leetcode/<pattern>/<ProblemName>Test.java
```

Packages are patterns, not difficulty, because interviews test pattern recognition:
`slidingwindow`, `twopointers`, `binarysearch`, `intervals`, `heap`, `monotonicstack`,
`graph`, `tree`, `backtracking`, `dp`, `trie`, `unionfind`.

## Conventions for each new problem

1. **Class name** = problem title in PascalCase (`MergeSortedArray`), method signature matches LeetCode.
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
| 88 | [Merge Sorted Array](src/main/java/io/github/sanjeet215/leetcode/twopointers/MergeSortedArray.java) | Two pointers (backward) | Easy |
| 340 | [Longest Substring with At Most K Distinct Characters](src/main/java/io/github/sanjeet215/leetcode/slidingwindow/LongestSubstringKDistinct.java) | Sliding window | Medium |
| — | [Merge Two Sorted Arrays](src/main/java/io/github/sanjeet215/leetcode/twopointers/MergeTwoSortedArrays.java) | Two pointers (merge step) | Easy |
