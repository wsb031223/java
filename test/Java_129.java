import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a grid with N rows and N columns (N >= 2) and a positive integer k,
    each cell of the grid contains a value. Every integer in the range [1, N * N]
    inclusive appears exactly once on the cells of the grid.

    You have to find the minimum path of length k in the grid. You can start
    from any cell, and in each step you can move to any of the neighbor cells,
    in other words, you can go to cells which share an edge with you current
    cell.
    Please note that a path of length k means visiting exactly k cells (not
    necessarily distinct).
    You CANNOT go off the grid.
    A path A (of length k) is considered less than a path B (of length k) if
    after making the ordered lists of the values on the cells that A and B go
    through (let's call them lst_A and lst_B), lst_A is lexicographically less
    than lst_B, in other words, there exist an integer index i (1 <= i <= k)
    such that lst_A[i] < lst_B[i] and for any j (1 <= j < i) we have
    lst_A[j] = lst_B[j].
    It is guaranteed that the answer is unique.
    Return an ordered list of the values on the cells that the minimum path go through.

    Examples:

        Input: grid = [ [1,2,3], [4,5,6], [7,8,9]], k = 3
        Output: [1, 2, 1]

        Input: grid = [ [5,9,3], [4,1,6], [7,8,2]], k = 1
        Output: [1]
     */
    public List<Integer> minPath(List<List<Integer>> grid, int k) {
        int n = grid.size();
        int minValue = Integer.MAX_VALUE;
        int startX = -1, startY = -1;
        
        // Find the smallest value to start with
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) < minValue) {
                    minValue = grid.get(i).get(j);
                    startX = i;
                    startY = j;
                }
            }
        }
        
        // If k is 1, return the smallest value
        if (k == 1) {
            return Arrays.asList(minValue);
        }
        
        // BFS to find the lexicographically smallest path
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            for (int i = 0; i < Math.min(a.path.size(), b.path.size()); i++) {
                int cmp = Integer.compare(a.path.get(i), b.path.get(i));
                if (cmp != 0) return cmp;
            }
            return Integer.compare(a.path.size(), b.path.size());
        });
        
        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(minValue);
        pq.offer(new State(startX, startY, initialPath));
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            
            if (current.path.size() == k) {
                return current.path;
            }
            
            int x = current.x;
            int y = current.y;
            
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    List<Integer> newPath = new ArrayList<>(current.path);
                    newPath.add(grid.get(nx).get(ny));
                    pq.offer(new State(nx, ny, newPath));
                }
            }
        }
        
        return new ArrayList<>();
    }
    
    class State {
        int x, y;
        List<Integer> path;
        
        State(int x, int y, List<Integer> path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 3).equals(Arrays.asList(1, 2, 1)),
                s.minPath(Arrays.asList(Arrays.asList(5, 9, 3), Arrays.asList(4, 1, 6), Arrays.asList(7, 8, 2)), 1).equals(List.of(1)),
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10, 11, 12), Arrays.asList(13, 14, 15, 16)), 4).equals(Arrays.asList(1, 2, 1, 2)),
                s.minPath(Arrays.asList(Arrays.asList(6, 4, 13, 10), Arrays.asList(5, 7, 12, 1), Arrays.asList(3, 16, 11, 15), Arrays.asList(8, 14, 9, 2)), 7).equals(Arrays.asList(1, 10, 1, 10, 1, 10, 1)),
                s.minPath(Arrays.asList(Arrays.asList(8, 14, 9, 2), Arrays.asList(6, 4, 13, 15), Arrays.asList(5, 7, 1, 12), Arrays.asList(3, 10, 11, 16)), 5).equals(Arrays.asList(1, 7, 1, 7, 1)),
                s.minPath(Arrays.asList(Arrays.asList(11, 8, 7, 2), Arrays.asList(5, 16, 14, 4), Arrays.asList(9, 3, 15, 6), Arrays.asList(12, 13, 10, 1)), 9).equals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1)),
                s.minPath(Arrays.asList(Arrays.asList(12, 13, 10, 1), Arrays.asList(9, 3, 15, 6), Arrays.asList(5, 16, 14, 4), Arrays.asList(11, 8, 7, 2)), 12).equals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6)),
                s.minPath(Arrays.asList(Arrays.asList(2, 7, 4), Arrays.asList(3, 1, 5), Arrays.asList(6, 8, 9)), 8).equals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3)),
                s.minPath(Arrays.asList(Arrays.asList(6, 1, 5), Arrays.asList(3, 8, 9), Arrays.asList(2, 7, 4)), 8).equals(Arrays.asList(1, 5, 1, 5, 1, 5, 1, 5)),
                s.minPath(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4)), 10).equals(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2)),
                s.minPath(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 2)), 10).equals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}