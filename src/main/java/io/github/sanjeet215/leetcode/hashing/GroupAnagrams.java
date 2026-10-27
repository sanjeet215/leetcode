package io.github.sanjeet215.leetcode.hashing;

import java.util.*;

/**
 * LC 49 - Group Anagrams.
 * <p>
 * https://leetcode.com/problems/group-anagrams/
 * <p>
 * Given an array of strings {@code strs}, group the anagrams together. An anagram is a word
 * formed by rearranging all the letters of another word, using each letter exactly once
 * ("eat", "tea", "ate"). Return the groups in any order; strings within a group may also be in
 * any order. {@code strs} has 1 to 10,000 strings, each 0 to 100 lowercase English letters.
 * <p>
 * Pattern: hashing with a canonical key. Key idea: anagrams have the same letter counts, so
 * build each word's letter frequencies in a {@link java.util.TreeMap} (keys stay sorted, so any
 * shuffle prints the same) and use its {@code toString()} as the map key. Words with the same key
 * land in the same group in a single pass. Pairwise comparison would be O(n^2 * k).
 * <p>
 * Alternatives: sorted letters as the key ("tea" -> "aet"), O(k log k) per word; or an
 * {@code int[26]} count array joined into a String, O(k) per word but only for a-z input.
 * <p>
 * Time: O(n * k log k) for n words of length up to k; at most 26 distinct letters, so close to
 * O(n * k) in practice. Space: O(n * k) for the groups and keys.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramGroups = new HashMap<>();

        Map<Character,Integer> letterFrequency = new TreeMap<>();

        for(String input: strs)
        {
            for(Character character:input.toCharArray())
            {
                letterFrequency.merge(character,1,Integer::sum);
            }
            String key = letterFrequency.toString();
            anagramGroups.computeIfAbsent(key,k -> new ArrayList<>()).add(input);
            letterFrequency.clear();
        }
        return new ArrayList<>(anagramGroups.values());
    }

    private boolean isAnagram(String word1,String word2)
    {
        if (word1.length() != word2.length()) return false;

        Map<Character,Integer> letterFrequency = new HashMap<>();
        for(Character character:word1.toCharArray())
        {
            letterFrequency.merge(character,1,Integer::sum);
        }

        for(Character character:word2.toCharArray())
        {
            if(letterFrequency.containsKey(character))
            {
                letterFrequency.computeIfPresent(character,(key, count) -> count == 1 ? null : count - 1);
            }
            else
            {
                return false;
            }
        }
        return letterFrequency.isEmpty();
    }
}
