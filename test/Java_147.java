import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a positive integer n. You have to create an integer array a of length n.
        For each i (1 <= i <= n), the value of a[i] = i * i - i + 1.
        Return the number of triples (a[i], a[j], a[k]) of a where i < j < k,
    and a[i] + a[j] + a[k] is a multiple of 3.

    Example :
        Input: n = 5
        Output: 1
        Explanation:
        a = [1, 3, 7, 13, 21]
        The only valid triple is (1, 7, 13).
     */
    public int getMaxTriples(int n) {
        // Let's think step by step
        // 1. Create array a of length n where a[i] = i*i - i + 1
        // 2. Count how many numbers in the array have remainder 0, 1, 2 when divided by 3
        // 3. We need to count triples (i,j,k) where (a[i] + a[j] + a[k]) % 3 == 0
        // 4. Possible combinations that sum to multiple of 3:
        //    - All three numbers have remainder 0
        //    - All three numbers have remainder 1
        //    - All three numbers have remainder 2
        //    - One number from each remainder group (0,1,2)
        // 5. Calculate combinations using the counts
        
        long[] a = new long[n];
        int count0 = 0, count1 = 0, count2 = 0;
        
        for (int i = 1; i <= n; i++) {
            long value = (long)i * i - i + 1;
            a[i-1] = value;
            int rem = (int)(value % 3);
            if (rem == 0) count0++;
            else if (rem == 1) count1++;
            else count2++;
        }
        
        // Calculate number of valid triples
        long total = 0;
        // All three with remainder 0
        total += (long)count0 * (count0 - 1) * (count0 - 2) / 6;
        // All three with remainder 1
        total += (long)count1 * (count1 - 1) * (count1 - 2) / 6;
        // All three with remainder 2
        total += (long)count2 * (count2 - 1) * (count2 - 2) / 6;
        // One from each group
        total += (long)count0 * count1 * count2;
        
        return (int)total;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.getMaxTriples(5) == 1,
                s.getMaxTriples(6) == 4,
                s.getMaxTriples(10) == 36,
                s.getMaxTriples(100) == 53361
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}