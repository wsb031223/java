def valid_date(date):
    """You have to write a function which validates a given date string and
    returns True if the date is valid otherwise False.
    The date is valid if all of the following rules are satisfied:
    1. The date string is not empty.
    2. The number of days is not less than 1 or higher than 31 days for months 1,3,5,7,8,10,12. And the number of days is not less than 1 or higher than 30 days for months 4,6,9,11. And, the number of days is not less than 1 or higher than 29 for the month 2.
    3. The months should not be less than 1 or higher than 12.
    4. The date should be in the format: mm-dd-yyyy

    for example: 
    valid_date('03-11-2000') => True

    valid_date('15-01-2012') => False

    valid_date('04-0-2040') => False

    valid_date('06-04-2020') => True

    valid_date('06/04/2020') => False
    """
    # Let's think step by step
    # Input: date (string in format mm-dd-yyyy)
    # Output: True if valid else False
    # Plan using three structures:
    # Sequential:
    # 1) Verify the input is a non-empty string with length 10 and '-' at positions 2 and 5.
    # 2) Check all other characters are digits using a loop.
    # 3) Parse month, day, and year as integers.
    # Branch:
    # 4) If month not in 1..12 -> return False.
    # 5) Compute max allowable day based on month (31, 30, or 29 for February).
    # 6) If day not in 1..max_day -> return False.
    # Loop:
    # - Use a for-loop to validate that all non-dash characters are digits.
    # Finally return True if all checks pass.

    # Sequential checks: type and basic format
    if not isinstance(date, str) or not date:
        return False
    if len(date) != 10:
        return False
    if date[2] != '-' or date[5] != '-':
        return False

    # Loop: ensure all non-dash characters are digits
    for idx, ch in enumerate(date):
        if idx in (2, 5):
            continue
        if not ch.isdigit():
            return False

    # Sequential: parse components
    mm = int(date[0:2])
    dd = int(date[3:5])
    yyyy = int(date[6:10])  # year presence validated by digits check and length

    # Branch: validate ranges
    if mm < 1 or mm > 12:
        return False

    if mm in (1, 3, 5, 7, 8, 10, 12):
        max_day = 31
    elif mm in (4, 6, 9, 11):
        max_day = 30
    else:  # February
        max_day = 29  # per problem statement, allow up to 29 regardless of leap year

    if dd < 1 or dd > max_day:
        return False

    # All checks passed
    return True

def check(valid_date):

    # Check some simple cases
    assert valid_date('03-11-2000') == True

    assert valid_date('15-01-2012') == False

    assert valid_date('04-0-2040') == False

    assert valid_date('06-04-2020') == True

    assert valid_date('01-01-2007') == True

    assert valid_date('03-32-2011') == False

    assert valid_date('') == False

    assert valid_date('04-31-3000') == False

    assert valid_date('06-06-2005') == True

    assert valid_date('21-31-2000') == False

    assert valid_date('04-12-2003') == True

    assert valid_date('04122003') == False

    assert valid_date('20030412') == False

    assert valid_date('2003-04') == False

    assert valid_date('2003-04-12') == False

    assert valid_date('04-2003') == False

check(valid_date)