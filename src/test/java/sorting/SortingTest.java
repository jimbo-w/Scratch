package sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortingTest {

    @Test
    public void mergeSort() {
        assertThat(Mergesort.sort(Arrays.asList(3, 2, 1)).toString(), is("[1,2,3]"));
    }
}
