import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string representing a space separated lowercase letters, return a dictionary
    of the letter with the most repetition and containing the corresponding count.
    If several letters have the same occurrence, return all of them.

    Example:
    histogram("a b c") == {"a": 1, "b": 1, "c": 1}
    histogram("a b b a") == {"a": 2, "b": 2}
    histogram("a b c a b") == {"a": 2, "b": 2}
    histogram("b b b b a") == {"b": 4}
    histogram("") == {}
     */
    public Map<String, Integer> histogram(String test) {
        // Let's think step by step
        // Input: string with space separated lowercase letters
        // Output: map of letters with maximum frequency
        // 1. If input is empty, return empty map
        // 2. Split the string by spaces to get individual letters
        // 3. Count frequency of each letter using a map
        // 4. Find the maximum frequency value
        // 5. Create result map with all letters that have maximum frequency
        // 6. Return the result map
        
        if (test == null || test.isEmpty()) {
            return new HashMap<>();
        }
        
        String[] letters = test.split(" ");
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (String letter : letters) {
            frequencyMap.put(letter, frequencyMap.getOrDefault(letter, 0) + 1);
        }
        
        int maxFrequency = 0;
        for (int count : frequencyMap.values()) {
            if (count > maxFrequency) {
                maxFrequency = count;
            }
        }
        
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 2);
        map1.put("b", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 2);
        map2.put("b", 2);
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("a", 1);
        map3.put("b", 1);
        map3.put("c", 1);
        map3.put("d", 1);
        map3.put("g", 1);
        Map<String, Integer> map4 = new HashMap<>();
        map4.put("r", 1);
        map4.put("t", 1);
        map4.put("g", 1);
        Map<String, Integer> map5 = new HashMap<>();
        map5.put("b", 4);
        Map<String, Integer> map6 = new HashMap<>();
        map6.put("r", 1);
        map6.put("t", 1);
        map6.put("g", 1);
        Map<String, Integer> map7 = new HashMap<>();
        Map<String, Integer> map8 = new HashMap<>();
        map8.put("a", 1);
        List<Boolean> correct = Arrays.asList(
                s.histogram("a b b a" ).equals(map1),
                s.histogram("a b c a b" ).equals(map2),
                s.histogram("a b c d g" ).equals(map3),
                s.histogram("r t g" ).equals(map4),
                s.histogram("b b b b a" ).equals(map5),
                s.histogram("r t g" ).equals(map6),
                s.histogram("" ).equals(map7),
                s.histogram("a" ).equals(map8)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}