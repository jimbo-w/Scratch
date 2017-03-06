package hackerrank.journeytothemoon;

import org.junit.Test;

import java.util.*;

import static hackerrank.journeytothemoon.Solution.createCountryToPersonMap;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void shouldCreateMap() {
        Solution.Pair one = new Solution.Pair(0, 1);
        Solution.Pair two = new Solution.Pair(2, 3);
        Set<Solution.Pair> pairs = new HashSet<>(Arrays.asList(one, two));

        Map<Integer, Set<Integer>> expected = new HashMap<>();
        expected.put(1, new HashSet<>(Arrays.asList(0, 1)));
        expected.put(2, new HashSet<>(Arrays.asList(2, 3)));

        Map<Integer, Set<Integer>> unit = createCountryToPersonMap(pairs);

        assertThat(unit.entrySet(), everyItem(isIn(expected.entrySet())));

    }


}