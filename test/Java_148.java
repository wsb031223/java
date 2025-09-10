import java.util.*;
import java.lang.*;

class Solution {
    /**
    There are eight planets in our solar system: the closerst to the Sun
    is Mercury, the next one is Venus, then Earth, Mars, Jupiter, Saturn,
    Uranus, Neptune.
    Write a function that takes two planet names as strings planet1 and planet2.
    The function should return a tuple containing all planets whose orbits are
    located between the orbit of planet1 and the orbit of planet2, sorted by
    the proximity to the sun.
    The function should return an empty tuple if planet1 or planet2
    are not correct planet names.
    Examples
    bf("Jupiter", "Neptune") ==> ["Saturn", "Uranus"]
    bf("Earth", "Mercury") ==> ["Venus"]
    bf("Mercury", "Uranus") ==> ["Venus", "Earth", "Mars", "Jupiter", "Saturn"]
     */
    public List<String> bf(String planet1, String planet2) {
        // Let's think step by step
        // Input: planet1, planet2 (strings)
        // Output: list of planet names strictly between their orbits, ordered by proximity to the Sun
        // Sequential: define ordered planets list, build index map, compute bounds, collect results, return
        // Branch: validate planet names; handle cases where indices are equal or adjacent
        // Loop: build the map and collect planets between indices
        // 1. Create an ordered list of planets from closest to farthest from the Sun.
        // 2. Build a map from planet name to its index in the ordered list.
        // 3. If either planet name is invalid, return an empty list.
        // 4. Determine lower and upper indices between the two planets.
        // 5. Loop through indices strictly between lower and upper, adding planets to the result.
        // 6. Return the result list.

        List<String> ordered = Arrays.asList(
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
        );

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < ordered.size(); i++) {
            index.put(ordered.get(i), i);
        }

        if (!index.containsKey(planet1) || !index.containsKey(planet2)) {
            return new ArrayList<>();
        }

        int i1 = index.get(planet1);
        int i2 = index.get(planet2);
        int lo = Math.min(i1, i2);
        int hi = Math.max(i1, i2);

        List<String> result = new ArrayList<>();
        for (int i = lo + 1; i < hi; i++) {
            result.add(ordered.get(i));
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.bf("Jupiter", "Neptune").equals(Arrays.asList("Saturn", "Uranus")),
                s.bf("Earth", "Mercury").equals(List.of("Venus")),
                s.bf("Mercury", "Uranus").equals(Arrays.asList("Venus", "Earth", "Mars", "Jupiter", "Saturn")),
                s.bf("Neptune", "Venus").equals(Arrays.asList("Earth", "Mars", "Jupiter", "Saturn", "Uranus")),
                s.bf("Earth", "Earth").equals(List.of()),
                s.bf("Mars", "Earth").equals(List.of()),
                s.bf("Jupiter", "Makemake").equals(List.of())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}