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
        // 1. Check if date is empty
        // 2. Check if the string has correct format (mm-dd-yyyy) with exactly 2 dashes
        // 3. Split the string into month, day, and year parts
        // 4. Check if all parts are numeric
        // 5. Convert parts to integers
        // 6. Check if month is between 1-12
        // 7. Check if day is valid for the given month
        // 8. Return true if all checks pass
        
        if (date == null || date.isEmpty()) {
            return false;
        }
        
        if (!date.matches("\\d{2}-\\d{2}-\\d{4}")) {
            return false;
        }
        
        String[] parts = date.split("-");
        if (parts.length != 3) {
            return false;
        }
        
        try {
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            
            if (month < 1 || month > 12) {
                return false;
            }
            
            if (day < 1) {
                return false;
            }
            
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 31) {
                    return false;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    return false;
                }
            } else if (month == 2) {
                if (day > 29) {
                    return false;
                }
            }
            
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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