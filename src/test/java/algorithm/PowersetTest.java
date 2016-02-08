package algorithm;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PowersetTest {
    private static final Logger logger = LoggerFactory.getLogger(PowersetTest.class);

    @Test
    public void powerset() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Set<Integer>> powerset = Powerset.powerset(set);

        logger.info(powerset.toString());
    }
}
