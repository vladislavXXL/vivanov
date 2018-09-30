package ru.job4j3.collectionspro.map;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Compare two words with equals characters.
 * @author v.ivanov
 * @version 1
 * @since 30.09.2018
 */
public class WordsCompare {

    /**
     * Check if the words has equals set of characters.
     * @param word1 first word
     * @param word2 second word
     * @return result true or false
     */
    public boolean isCharsEquals(String word1, String word2) {
        boolean result = true;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            set.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            if (!set.contains(word2.charAt(i))) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Check if the words are complete equals.
     * @param word1 first word
     * @param word2 second word
     * @return result true or false
     */
    public boolean isCompleteEquals(String word1, String word2) {
        boolean result = true;
        Map<Integer, Character> map1 = new HashMap<>();
        Map<Integer, Character> map2 = new HashMap<>();
        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                map1.put(i, word1.charAt(i));
                map2.put(i, word2.charAt(i));
            }
            Iterator<Map.Entry<Integer, Character>> itr = map1.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<Integer, Character> itrs = itr.next();
                if (!itrs.getValue().equals(map2.get(itrs.getKey()))) {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
