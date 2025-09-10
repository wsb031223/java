def minPath(grid, k):
    """
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
    """
    n = len(grid)
    # Find the starting cell with the smallest value
    min_val = float('inf')
    start_i, start_j = -1, -1
    for i in range(n):
        for j in range(n):
            if grid[i][j] < min_val:
                min_val = grid[i][j]
                start_i, start_j = i, j
    
    # If k is 1, return the smallest value
    if k == 1:
        return [min_val]
    
    # Directions for neighbors: up, down, left, right
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    # BFS with state: (path, i, j)
    # We need to find the lexicographically smallest path of length k
    from collections import deque
    queue = deque()
    initial_path = [min_val]
    queue.append((initial_path, start_i, start_j))
    
    for step in range(k - 1):
        next_level = []
        while queue:
            path, i, j = queue.popleft()
            for dx, dy in directions:
                ni, nj = i + dx, j + dy
                if 0 <= ni < n and 0 <= nj < n:
                    new_path = path + [grid[ni][nj]]
                    next_level.append((new_path, ni, nj))
        # Sort the next level lexicographically and keep only the best candidates
        next_level.sort(key=lambda x: x[0])
        # Only keep paths that are still potentially the best
        # Since the answer is unique, we can take the first one and any that are equal to it
        best_path = next_level[0][0]
        queue = deque()
        for path, i, j in next_level:
            if path == best_path:
                queue.append((path, i, j))
            else:
                break
    
    # The first path in the queue is the lexicographically smallest
    return queue[0][0]

def check(minPath):

    # Check some simple cases
    print
    assert minPath([[1, 2, 3], [4, 5, 6], [7, 8, 9]], 3) == [1, 2, 1]
    assert minPath([[5, 9, 3], [4, 1, 6], [7, 8, 2]], 1) == [1]
    assert minPath([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]], 4) == [1, 2, 1, 2]
    assert minPath([[6, 4, 13, 10], [5, 7, 12, 1], [3, 16, 11, 15], [8, 14, 9, 2]], 7) == [1, 10, 1, 10, 1, 10, 1]
    assert minPath([[8, 14, 9, 2], [6, 4, 13, 15], [5, 7, 1, 12], [3, 10, 11, 16]], 5) == [1, 7, 1, 7, 1]
    assert minPath([[11, 8, 7, 2], [5, 16, 14, 4], [9, 3, 15, 6], [12, 13, 10, 1]], 9) == [1, 6, 1, 6, 1, 6, 1, 6, 1]
    assert minPath([[12, 13, 10, 1], [9, 3, 15, 6], [5, 16, 14, 4], [11, 8, 7, 2]], 12) == [1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6]
    assert minPath([[2, 7, 4], [3, 1, 5], [6, 8, 9]], 8) == [1, 3, 1, 3, 1, 3, 1, 3]
    assert minPath([[6, 1, 5], [3, 8, 9], [2, 7, 4]], 8) == [1, 5, 1, 5, 1, 5, 1, 5]

    # Check some edge cases that are easy to work out by hand.
    assert minPath([[1, 2], [3, 4]], 10) == [1, 2, 1, 2, 1, 2, 1, 2, 1, 2]
    assert minPath([[1, 3], [3, 2]], 10) == [1, 3, 1, 3, 1, 3, 1, 3, 1, 3]

check(minPath)