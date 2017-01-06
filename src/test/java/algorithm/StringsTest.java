package algorithm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringsTest {

    @Test
    public void replace() {
        char[] s = "Mr John Smith    ".toCharArray();
        Strings.replaceSpaces(s, 4);
        assertThat(String.valueOf(s), is("Mr%20John%20Smith"));
    }
}
