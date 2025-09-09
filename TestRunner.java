import java.util.*;

public class TestRunner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        List<List<Integer>> testCases = Arrays.asList(
            Arrays.asList(),           // Empty list
            Arrays.asList(1),          // Single element
            Arrays.asList(1, 2, 3, 4)  // Multiple elements
        );

        // Expected results
        List<List<Integer>> expectedResults = Arrays.asList(
            Arrays.asList(0, 1),  // Empty list
            Arrays.asList(1, 1),  // Single element
            Arrays.asList(10, 24) // Multiple elements
        );

        // Run through test cases
        for (int i = 0; i < testCases.size(); i++) {
            List<Integer> result = solution.sumProduct(testCases.get(i));
            System.out.println("Test case " + (i + 1) + ": " + (result.equals(expectedResults.get(i)) ? "Passed" : "Failed") + " - Output: " + result + ", Expected: " + expectedResults.get(i));
        }
    }
}
