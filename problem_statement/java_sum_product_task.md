# Task Description: Sum and Product of a List of Integers

## Problem Statement

For a given list of integers, return a tuple consisting of a sum and a product of all the integers in the list.

- Empty sum should be equal to 0.
- Empty product should be equal to 1.

### Example

```java
>>> sumProduct(List.of())
[0, 1]

>>> sumProduct(Arrays.asList(1, 2, 3, 4))
[10, 24]

### Code Implementation Logic

1. **Initialize Variables**:
   - In the `sumProduct` method, we initialize two variables:
     - `sum`: Initially set to `0`, used to store the sum of the numbers.
     - `product`: Initially set to `1`, used to store the product of the numbers.
   
2. **Handle Empty List**:
   - Before performing calculations, the method checks if the input list is empty. If it is, the method returns `[0, 1]` (sum = `0`, product = `1`).

3. **Iterate Through the List to Calculate Sum and Product**:
   - If the list is not empty, the method iterates through each number in the list:
     - Adds each number to `sum`, updating the total sum.
     - Multiplies each number with `product`, updating the total product.

4. **Return Result**:
   - Finally, the method returns a list containing `sum` and `product`, i.e., `[sum, product]`.
