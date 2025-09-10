import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function that takes integers, floats, or strings representing
    real numbers, and returns the larger variable in its given variable type.
    Return None if the values are equal.
    Note: If a real number is represented as a string, the floating point might be . or ,

    compareOne(1, 2.5) -> Optional.of(2.5)
    compareOne(1, "2,3") -> Optional.of("2,3")
    compareOne("5,1", "6") -> Optional.of("6")
    compareOne("1", 1) -> Optional.empty()
     */
    public Optional<Object> compareOne(Object a, Object b) {
        // Let's think step by step
        // 1. Convert both inputs to double values for comparison
        // 2. Handle different input types: Integer, Double, String
        // 3. For strings, replace comma with dot to handle different decimal formats
        // 4. Compare the converted double values
        // 5. If equal, return Optional.empty()
        // 6. If not equal, return the original object with the larger value
        
        double valA = convertToDouble(a);
        double valB = convertToDouble(b);
        
        if (valA == valB) {
            return Optional.empty();
        } else if (valA > valB) {
            return Optional.of(a);
        } else {
            return Optional.of(b);
        }
    }
    
    private double convertToDouble(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).doubleValue();
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else if (obj instanceof String) {
            String str = (String) obj;
            str = str.replace(',', '.');
            return Double.parseDouble(str);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                (int) s.compareOne(1, 2).get() == 2,
                (double) s.compareOne(1, 2.5).get() == 2.5,
                (int) s.compareOne(2, 3).get() == 3,
                (int) s.compareOne(5, 6).get() == 6,
                (String) s.compareOne(1, "2,3").get() == "2,3",
                (String) s.compareOne("5,1", "6").get() == "6",
                (String) s.compareOne("1", "2").get() == "2",
                s.compareOne("1", 1).isEmpty()
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}