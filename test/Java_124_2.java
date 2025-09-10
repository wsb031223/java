import java.util.*;
import java.lang.*;

class Solution {
    /**
    You have to write a function which validates a given date string and
    returns true if the date is valid otherwise false.
    The date is valid if all of the following rules are satisfied:
    1. The date string is not empty.
    2. The number of days is not less than 1 or higher than 31 days for months 1,3,5,7,8,10,12. And the number of days is not less than 1 or higher than 30 days for months 4,6,9,11. And, the number of days is not less than 1 or higher than 29 for the month 2.
    3. The months should not be less than 1 or higher than 12.
    4. The date should be in the format: mm-dd-yyyy

    for example:
    validDate("03-11-2000") => true
    validDate("15-01-2012") => false
    validDate("04-0-2040") => false
    validDate("06-04-2020") => true
    validDate("06/04/2020") => false
     */
    public boolean validDate(String date) {
        // Let's think step by step
        // Input: date, a string
        // Output: boolean indicating validity
        // 1. Sequential: Check for null or empty string.
        // 2. Sequential: Verify exact length (10) and '-' at positions 2 and 5 (mm-dd-yyyy).
        // 3. Loop: Ensure all other characters are digits.
        // 4. Sequential: Parse month, day, year from substrings.
        // 5. Branch: Validate month is between 1 and 12.
        // 6. Branch: Determine max days for the given month (Feb up to 29 as per problem).
        // 7. Branch: Validate day range [1..maxDays].
        // 8. Sequential: Return true if all checks pass, otherwise false.

        if (date == null || date.isEmpty()) {
            return false;
        }
        if (date.length() != 10) {
            return false;
        }
        if (date.charAt(2) != '-' || date.charAt(5) != '-') {
            return false;
        }

        for (int i = 0; i < date.length(); i++) {
            if (i == 2 || i == 5) continue;
            char c = date.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10)); // year can be any 4-digit number

        if (month < 1 || month > 12) {
            return false;
        }

        int maxDays;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            maxDays = 31;
        } else if (month == 2) {
            maxDays = 29; // As per problem statement, allow up to 29 days in February
        } else {
            maxDays = 30;
        }

        if (day < 1 || day > maxDays) {
            return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.validDate("03-11-2000" ) == true,
                s.validDate("15-01-2012" ) == false,
                s.validDate("04-0-2040" ) == false,
                s.validDate("06-04-2020" ) == true,
                s.validDate("01-01-2007" ) == true,
                s.validDate("03-32-2011" ) == false,
                s.validDate("" ) == false,
                s.validDate("04-31-3000" ) == false,
                s.validDate("06-06-2005" ) == true,
                s.validDate("21-31-2000" ) == false,
                s.validDate("04-12-2003" ) == true,
                s.validDate("04122003" ) == false,
                s.validDate("20030412" ) == false,
                s.validDate("2003-04" ) == false,
                s.validDate("2003-04-12" ) == false,
                s.validDate("04-2003" ) == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}