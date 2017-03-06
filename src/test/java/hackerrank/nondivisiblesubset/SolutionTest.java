package hackerrank.nondivisiblesubset;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static hackerrank.nondivisiblesubset.Solution.nonDivisibleSubsetsUsingRemainders;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class SolutionTest {
    @Test
    public void shouldfindNonDivisibleSubset() throws Exception {
        int k = 3;
        Set<Integer> s = new HashSet<>(Arrays.asList(1, 7, 2, 4));

        int unit = nonDivisibleSubsetsUsingRemainders(k, s);
        assertThat(unit, is(3));
    }
    
    @Test
    public void largeNumbers() {
        int k = 11;
        Set<Integer> s = new HashSet<>(Arrays.asList(582740017, 954896345, 590538156, 298333230, 859747706, 155195851, 331503493, 799588305, 164222042, 563356693, 80522822, 432354938, 652248359));
        int unit = nonDivisibleSubsetsUsingRemainders(11, s);

        assertThat(unit, is(k));
    }

    @Test
    public void singleDivisibleValue() {
        int k = 2;
        Set<Integer> s = new HashSet<>(Collections.singletonList(4));
        int unit = nonDivisibleSubsetsUsingRemainders(k, s);

        assertThat(unit, is(1));
    }

}