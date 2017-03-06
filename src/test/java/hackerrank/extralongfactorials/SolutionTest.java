package hackerrank.extralongfactorials;

import org.junit.Test;

import java.math.BigInteger;

import static hackerrank.extralongfactorials.Solution.factorial;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void shouldPrintForSmallumber() {
        assertThat(factorial(5), is(BigInteger.valueOf(120)));
    }

    @Test
    public void shouldPrintFor25() {
        assertThat(factorial(25).toString(), is("15511210043330985984000000"));
    }

}