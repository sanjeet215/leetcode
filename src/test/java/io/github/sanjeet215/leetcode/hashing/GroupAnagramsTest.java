package io.github.sanjeet215.leetcode.hashing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GroupAnagramsTest {

    private final GroupAnagrams solution = new GroupAnagrams();

    static Stream<Arguments> cases() {
        return Stream.of(
                // LeetCode examples
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"))),
                Arguments.of(new String[]{""}, List.of(List.of(""))),                       // empty string
                Arguments.of(new String[]{"a"}, List.of(List.of("a"))),
                // Edge cases
                Arguments.of(new String[]{"", ""}, List.of(List.of("", ""))),               // empty strings group together
                Arguments.of(new String[]{"abc", "abc"}, List.of(List.of("abc", "abc"))),   // identical words stay separate entries
                Arguments.of(new String[]{"ab", "ba", "abc"},
                        List.of(List.of("ab", "ba"), List.of("abc"))),                      // same letters, different length
                Arguments.of(new String[]{"aab", "abb"},
                        List.of(List.of("aab"), List.of("abb"))),                           // same letter set, different counts
                Arguments.of(new String[]{"ad", "bc"},
                        List.of(List.of("ad"), List.of("bc"))),                             // equal char sums (197): breaks "sum of chars" keys
                Arguments.of(new String[]{"abc", "def", "ghi"},
                        List.of(List.of("abc"), List.of("def"), List.of("ghi"))));          // no anagrams at all
    }

    @ParameterizedTest
    @MethodSource("cases")
    void groupsAnagramsTogether(String[] strs, List<List<String>> expected) {
        // Group order and order within a group don't matter, so compare sorted groups in any order.
        assertThat(normalize(solution.groupAnagrams(strs))).containsExactlyInAnyOrderElementsOf(normalize(expected));
    }

    private static List<List<String>> normalize(List<List<String>> groups) {
        List<List<String>> out = new ArrayList<>();
        for (List<String> g : groups) {
            List<String> sorted = new ArrayList<>(g);
            sorted.sort(null);
            out.add(sorted);
        }
        return out;
    }
}
