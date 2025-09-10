def numerical_letter_grade(grades):
    """It is the last week of the semester and the teacher has to give the grades
    to students. The teacher has been making her own algorithm for grading.
    The only problem is, she has lost the code she used for grading.
    She has given you a list of GPAs for some students and you have to write 
    a function that can output a list of letter grades using the following table:
             GPA       |    Letter grade
              4.0                A+
            > 3.7                A 
            > 3.3                A- 
            > 3.0                B+
            > 2.7                B 
            > 2.3                B-
            > 2.0                C+
            > 1.7                C
            > 1.3                C-
            > 1.0                D+ 
            > 0.7                D 
            > 0.0                D-
              0.0                E
    
    Example:
    grade_equation([4.0, 3, 1.7, 2, 3.5]) ==> ['A+', 'B', 'C-', 'C', 'A-']
    """
    # Let's think step by step
    # Input: list of GPAs
    # Output: list of letter grades
    # 1. Initialize an empty list for results
    # 2. Loop through each GPA in the input list
    # 3. Use if-elif-else branching to determine the letter grade based on GPA value
    # 4. Append the corresponding letter grade to the result list
    # 5. Return the result list
    
    result = []
    for gpa in grades:
        if gpa == 4.0:
            result.append('A+')
        elif gpa > 3.7:
            result.append('A')
        elif gpa > 3.3:
            result.append('A-')
        elif gpa > 3.0:
            result.append('B+')
        elif gpa > 2.7:
            result.append('B')
        elif gpa > 2.3:
            result.append('B-')
        elif gpa > 2.0:
            result.append('C+')
        elif gpa > 1.7:
            result.append('C')
        elif gpa > 1.3:
            result.append('C-')
        elif gpa > 1.0:
            result.append('D+')
        elif gpa > 0.7:
            result.append('D')
        elif gpa > 0.0:
            result.append('D-')
        else:
            result.append('E')
    return result

def check(numerical_letter_grade):

    # Check some simple cases
    assert numerical_letter_grade([4.0, 3, 1.7, 2, 3.5]) == ['A+', 'B', 'C-', 'C', 'A-']
    assert numerical_letter_grade([1.2]) == ['D+']
    assert numerical_letter_grade([0.5]) == ['D-']
    assert numerical_letter_grade([0.0]) == ['E']
    assert numerical_letter_grade([1, 0.3, 1.5, 2.8, 3.3]) == ['D', 'D-', 'C-', 'B', 'B+']
    assert numerical_letter_grade([0, 0.7]) == ['E', 'D-']

    # Check some edge cases that are easy to work out by hand.
    assert True

check(numerical_letter_grade)