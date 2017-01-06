package bitmanipulation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BitFunctionsTest {

    @Test
    public void decimalToBinary() {
        assertThat(BitFunctions.decimalToBinary(1.1), is("ERROR"));
        assertThat(BitFunctions.decimalToBinary(0.5), is("0.1"));
        assertThat(BitFunctions.decimalToBinary(0.625), is("0.101"));
        assertThat("decimal 0.1 cannot be fully represented in binary", BitFunctions.decimalToBinary(0.1), is("ERROR"));
    }

    @Test
    public void bitDiffs() {
        assertThat(BitFunctions.bitDiffs(8, 11), is(2));
    }
}
