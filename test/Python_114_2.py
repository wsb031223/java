def minSubArraySum(nums):
    """
    Given an array of integers nums, find the minimum sum of any non-empty sub-array
    of nums.
    Example
    minSubArraySum([2, 3, 4, 1, 2, 4]) == 1
    minSubArraySum([-1, -2, -3]) == -6
    """
    # Let's think step by step
    # Input: nums, a list of integers
    # Output: an integer representing the minimum subarray sum
    # 1. (Branch) If the input list is empty, raise an error because a non-empty subarray is required.
    # 2. (Sequential) Initialize two variables:
    #    - curr_min: the minimum sum ending at the current position
    #    - best_min: the best (smallest) sum seen so far
    # 3. (Loop) Iterate through the array starting from the second element.
    # 4. (Branch) For each element x:
    #    - Decide whether to extend the previous subarray (curr_min + x) or start a new subarray at x.
    #    - Update best_min if the current subarray sum is smaller.
    # 5. (Sequential) Return best_min as the final result.
    if not nums:
        raise ValueError("nums must be non-empty")

    curr_min = nums[0]
    best_min = nums[0]

    for x in nums[1:]:
        if curr_min + x < x:
            curr_min = curr_min + x
        else:
            curr_min = x

        if curr_min < best_min:
            best_min = curr_min

    return best_min

def check(minSubArraySum):

    # Check some simple cases
    assert minSubArraySum([2, 3, 4, 1, 2, 4]) == 1, "This prints if this assert fails 1 (good for debugging!)"
    assert minSubArraySum([-1, -2, -3]) == -6
    assert minSubArraySum([-1, -2, -3, 2, -10]) == -14
    assert minSubArraySum([-9999999999999999]) == -9999999999999999
    assert minSubArraySum([0, 10, 20, 1000000]) == 0
    assert minSubArraySum([-1, -2, -3, 10, -5]) == -6
    assert minSubArraySum([100, -1, -2, -3, 10, -5]) == -6
    assert minSubArraySum([10, 11, 13, 8, 3, 4]) == 3
    assert minSubArraySum([100, -33, 32, -1, 0, -2]) == -33

    # Check some edge cases that are easy to work out by hand.
    assert minSubArraySum([-10]) == -10, "This prints if this assert fails 2 (also good for debugging!)"
    assert minSubArraySum([7]) == 7
    assert minSubArraySum([1, -1]) == -1

check(minSubArraySum)