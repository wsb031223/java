import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a map, return True if all keys are strings in lower
    case or all keys are strings in upper case, else return False.
    The function should return False is the given map is empty.
    Examples:
    checkDictCase({"a":"apple", "b":"banana"}) should return True.
    checkDictCase({"a":"apple", "A":"banana", "B":"banana"}) should return False.
    checkDictCase({"a":"apple", 8:"banana", "a":"apple"}) should return False.
    checkDictCase({"Name":"John", "Age":"36", "City":"Houston"}) should return False.
    checkDictCase({"STATE":"NC", "ZIP":"12345" }) should return True.
     */
    public boolean checkDictCase(Map<Object, Object> dict) {
        // Let's think step by step
        // Input: dict, a map with Object keys and Object values
        // Output: boolean value
        // 1. Check if map is empty - return false
        // 2. Check if all keys are strings
        // 3. If all keys are strings, check if they are all lowercase or all uppercase
        // 4. Return true if condition 3 is met, otherwise return false
        
        if (dict.isEmpty()) {
            return false;
        }
        
        boolean allLower = true;
        boolean allUpper = true;
        boolean allStrings = true;
        
        for (Object key : dict.keySet()) {
            if (!(key instanceof String)) {
                allStrings = false;
                break;
            }
            
            String strKey = (String) key;
            if (!strKey.equals(strKey.toLowerCase())) {
                allLower = false;
            }
            if (!strKey.equals(strKey.toUpperCase())) {
                allUpper = false;
            }
        }
        
        if (!allStrings) {
            return false;
        }
        
        return allLower || allUpper;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("p", "pineapple");
        map1.put("b", "banana");
        Map<Object, Object> map2 = new HashMap<>();
        map2.put("p", "pineapple");
        map2.put("A", "banana");
        map2.put("B", "banana");
        Map<Object, Object> map3 = new HashMap<>();
        map3.put("p", "pineapple");
        map3.put(5, "banana");
        map3.put("a", "banana");
        Map<Object, Object> map4 = new HashMap<>();
        map4.put("Name", "John");
        map4.put("Age", "36");
        map4.put("City", "Houston");
        Map<Object, Object> map5 = new HashMap<>();
        map5.put("STATE", "NC");
        map5.put("ZIP", "12345");
        Map<Object, Object> map6 = new HashMap<>();
        map6.put("fruit", "Orange");
        map6.put("taste", "Sweet");
        Map<Object, Object> map7 = new HashMap<>();
        List<Boolean> correct = Arrays.asList(
                s.checkDictCase(map1),
                !s.checkDictCase(map2),
                !s.checkDictCase(map3),
                !s.checkDictCase(map4),
                s.checkDictCase(map5),
                s.checkDictCase(map6),
                !s.checkDictCase(map7)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}