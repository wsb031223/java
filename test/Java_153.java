import java.util.*;
import java.lang.*;

class Solution {
    /**
    You will be given the name of a class (a string) and a list of extensions.
    The extensions are to be used to load additional classes to the class. The
    strength of the extension is as follows: Let CAP be the number of the uppercase
    letters in the extension's name, and let SM be the number of lowercase letters
    in the extension's name, the strength is given by the fraction CAP - SM.
    You should find the strongest extension and return a string in this
    format: ClassName.StrongestExtensionName.
    If there are two or more extensions with the same strength, you should
    choose the one that comes first in the list.
    For example, if you are given "Slices" as the class and a list of the
    extensions: ["SErviNGSliCes", "Cheese", "StuFfed"] then you should
    return "Slices.SErviNGSliCes" since "SErviNGSliCes" is the strongest extension
    (its strength is -1).
    Example:
    for StrongestExtension("my_class", ["AA", "Be", "CC"]) == "my_class.AA"
     */
    public String StrongestExtension(String class_name, List<String> extensions) {
        // Let's think step by step
        // Input: class_name (String), extensions (List<String>)
        // Output: String formatted as "ClassName.StrongestExtensionName"
        // Sequential structure:
        // 1) Initialize tracking variables: maxStrength to the lowest integer and bestExt to empty string.
        // Loop structure:
        // 2) For each extension in the list:
        //    - Count uppercase (CAP) and lowercase (SM) letters by looping over characters.
        // Branch structure:
        //    - If a character is uppercase, increment CAP; else if lowercase, increment SM.
        //    - Compute strength = CAP - SM and update bestExt if strength is greater than current maxStrength.
        // Final step:
        // 3) Return class_name + "." + bestExt. If the list is null/empty, return class_name + ".".
        // Write your code here
        if (extensions == null || extensions.isEmpty()) {
            return class_name + ".";
        }

        int maxStrength = Integer.MIN_VALUE;
        String bestExt = extensions.get(0); // default to first for safety; will be updated if stronger found

        for (int idx = 0; idx < extensions.size(); idx++) {
            String ext = extensions.get(idx);
            int cap = 0;
            int sm = 0;

            for (int i = 0; i < ext.length(); i++) {
                char c = ext.charAt(i);
                if (Character.isUpperCase(c)) {
                    cap++;
                } else if (Character.isLowerCase(c)) {
                    sm++;
                }
                // Non-letter characters are ignored
            }

            int strength = cap - sm;

            if (strength > maxStrength) {
                maxStrength = strength;
                bestExt = ext; // update to current extension
            }
            // In case of tie (strength == maxStrength), we keep the first occurrence by doing nothing
        }

        return class_name + "." + bestExt;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.StrongestExtension("Watashi", Arrays.asList("tEN", "niNE", "eIGHt8OKe")), "Watashi.eIGHt8OKe"),
                Objects.equals(s.StrongestExtension("Boku123", Arrays.asList("nani", "NazeDa", "YEs.WeCaNe", "32145tggg")), "Boku123.YEs.WeCaNe"),
                Objects.equals(s.StrongestExtension("__YESIMHERE", Arrays.asList("t", "eMptY", "nothing", "zeR00", "NuLl__", "123NoooneB321")), "__YESIMHERE.NuLl__"),
                Objects.equals(s.StrongestExtension("K", Arrays.asList("Ta", "TAR", "t234An", "cosSo")), "K.TAR"),
                Objects.equals(s.StrongestExtension("__HAHA", Arrays.asList("Tab", "123", "781345", "-_-")), "__HAHA.123"),
                Objects.equals(s.StrongestExtension("YameRore", Arrays.asList("HhAas", "okIWILL123", "WorkOut", "Fails", "-_-")), "YameRore.okIWILL123"),
                Objects.equals(s.StrongestExtension("finNNalLLly", Arrays.asList("Die", "NowW", "Wow", "WoW")), "finNNalLLly.WoW"),
                Objects.equals(s.StrongestExtension("_", Arrays.asList("Bb", "91245")), "_.Bb"),
                Objects.equals(s.StrongestExtension("Sp", Arrays.asList("671235", "Bb")), "Sp.671235")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}