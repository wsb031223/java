def add(lst):
    """Given a non-empty list of integers lst. add the even elements that are at odd indices..


    Examples:
        add([4, 2, 6, 7]) ==> 2 
    """
    # Let's think step by step
    # Input: lst, a list of integers
    # Output: sum of even elements at odd indices
    # 1. Initialize a variable "total" to 0 to store the sum
    # 2. Loop through the list indices using a for loop
    # 3. For each index, check if it's odd (index % 2 != 0)
    # 4. If index is odd, check if the element at that index is even (element % 2 == 0)
    # 5. If both conditions are true, add the element to total
    # 6. Return the total
    total = 0
    for i in range(len(lst)):
        if i % 2 != 0 and lst[i] % 2 == 0:
            total += lst[i]
    return total

def check(add):

    # Check some simple cases
    assert add([4, 88]) == 88
    assert add([4, 5, 6, 7, 2, 122]) == 122
    assert add([4, 0, 6, 7]) == 0
    assert add([4, 4, 6, 8]) == 12

    # Check some edge cases that are easy to work out by hand.

check(add)