def max_fill(grid, capacity):
    import math
    """
    You are given a rectangular grid of wells. Each row represents a single well,
    and each 1 in a row represents a single unit of water.
    Each well has a corresponding bucket that can be used to extract water from it, 
    and all buckets have the same capacity.
    Your task is to use the buckets to empty the wells.
    Output the number of times you need to lower the buckets.

    Example 1:
        Input: 
            grid : [[0,0,1,0], [0,1,0,0], [1,1,1,1]]
            bucket_capacity : 1
        Output: 6

    Example 2:
        Input: 
            grid : [[0,0,1,1], [0,0,0,0], [1,1,1,1], [0,1,1,1]]
            bucket_capacity : 2
        Output: 5
    
    Example 3:
        Input: 
            grid : [[0,0,0], [0,0,0]]
            bucket_capacity : 5
        Output: 0

    Constraints:
        * all wells have the same length
        * 1 <= grid.length <= 10^2
        * 1 <= grid[:,1].length <= 10^2
        * grid[i][j] -> 0 | 1
        * 1 <= capacity <= 10
    """
    # Let's think step by step
    # Input: grid (list of lists with 0/1), capacity (int)
    # Output: total number of bucket lowerings (int)
    # Sequential structure:
    # 1) Initialize a counter for total lowerings.
    # Loop structure:
    # 2) For each row (well) in the grid:
    #    - Compute the total water units in this well.
    # Branch structure:
    #    - If the well has water (> 0), compute how many bucket lowerings are needed:
    #      ceil(water_in_well / capacity) and add to the counter.
    # 3) Return the total counter.

    lowerings = 0
    for row in grid:
        water_in_well = sum(row)
        if water_in_well > 0:
            lowerings += math.ceil(water_in_well / capacity)
    return lowerings

def check(max_fill):


    # Check some simple cases
    assert True, "This prints if this assert fails 1 (good for debugging!)"
    assert max_fill([[0,0,1,0], [0,1,0,0], [1,1,1,1]], 1) == 6, "Error"
    assert max_fill([[0,0,1,1], [0,0,0,0], [1,1,1,1], [0,1,1,1]], 2) == 5, "Error"
    assert max_fill([[0,0,0], [0,0,0]], 5) == 0, "Error"

    # Check some edge cases that are easy to work out by hand.
    assert True, "This prints if this assert fails 2 (also good for debugging!)"
    assert max_fill([[1,1,1,1], [1,1,1,1]], 2) == 4, "Error"
    assert max_fill([[1,1,1,1], [1,1,1,1]], 9) == 2, "Error"

check(max_fill)