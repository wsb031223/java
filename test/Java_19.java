import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input is a space-delimited string of numberals from 'zero' to 'nine'.
    Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
    Return the string with numbers sorted from smallest to largest
    >>> sortNumbers("three one five")
    "one three five"
     */
    public String sortNumbers(String numbers) {
        // Let's think step by step
        // Input: space-delimited string of number words
        // Output: sorted string of number words
        // 1. Split the input string into an array of words
        // 2. Create a mapping from word to numerical value
        // 3. Convert each word to its numerical value
        // 4. Sort the numerical values
        // 5. Convert sorted numerical values back to words
        // 6. Join the sorted words with spaces
        // 7. Return the result
        
        if (numbers == null || numbers.isEmpty()) {
            return "";
        }
        
        String[] words = numbers.split(" ");
        Map<String, Integer> wordToNum = new HashMap<>();
        wordToNum.put("zero", 0);
        wordToNum.put("one", 1);
        wordToNum.put("two", 2);
        wordToNum.put("three", 3);
        wordToNum.put("four", 4);
        wordToNum.put("five", 5);
        wordToNum.put("six", 6);
        wordToNum.put("seven", 7);
        wordToNum.put("eight", 8);
        wordToNum.put("nine", 9);
        
        List<Integer> nums = new ArrayList<>();
        for (String word : words) {
            nums.add(wordToNum.get(word));
        }
        
        Collections.sort(nums);
        
        Map<Integer, String> numToWord = new HashMap<>();
        numToWord.put(0, "zero");
        numToWord.put(1, "one");
        numToWord.put(2, "two");
        numToWord.put(3, "three");
        numToWord.put(4, "four");
        numToWord.put(5, "five");
        numToWord.put(6, "six");
        numToWord.put(7, "seven");
        numToWord.put(8, "eight");
        numToWord.put(9, "nine");
        
        List<String> sortedWords = new ArrayList<>();
        for (int num : nums) {
            sortedWords.add(numToWord.get(num));
        }
        
        return String.join(" ", sortedWords);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortNumbers("").equals(""),
                s.sortNumbers("three").equals("three"),
                s.sortNumbers("three five nine").equals("three five nine"),
                s.sortNumbers("five zero four seven nine eight").equals("zero four five seven eight nine")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}