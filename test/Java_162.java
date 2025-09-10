import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string "text", return its md5 hash equivalent string with length being 32.
    If "text" is an empty string, return Optional.empty().
    
    >>> stringToMd5("Hello world") == "3e25960a79dbc69b674cd4ec67a72c62"
     */
    public Optional<String> stringToMd5(String text) throws NoSuchAlgorithmException {
        // Let's think step by step
        // Input: text, a string
        // Output: Optional containing MD5 hash string or empty Optional
        // 1. Check if input text is empty - return Optional.empty()
        // 2. Get MD5 MessageDigest instance
        // 3. Convert text to bytes and compute hash
        // 4. Convert hash bytes to hexadecimal string
        // 5. Pad with leading zeros if necessary to ensure 32-character length
        // 6. Return Optional containing the hash string
        
        if (text.isEmpty()) {
            return Optional.empty();
        }
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(text.getBytes());
        BigInteger num = new BigInteger(1, digest);
        String hash = num.toString(16);
        
        while (hash.length() < 32) {
            hash = "0" + hash;
        }
        
        return Optional.of(hash);
    }
}

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.stringToMd5("Hello world").get().equals("3e25960a79dbc69b674cd4ec67a72c62"),
                s.stringToMd5("").isEmpty(),
                s.stringToMd5("A B C").get().equals("0ef78513b0cb8cef12743f5aeb35f888"),
                s.stringToMd5("password").get().equals("5f4dcc3b5aa765d61d8327deb882cf99")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}