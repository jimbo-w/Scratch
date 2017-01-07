package testing;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItems;

public class AssertCollectionWithCollectionOfMatchersTest {

    @Test
    public void matcherTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("A String");
        stringList.add("Another String");
        stringList.add("Not a String");

        List<Matcher<? super String>> matchers = new ArrayList<>();
        matchers.add(CoreMatchers.containsString("fail"));
        matchers.add(CoreMatchers.containsString("A"));

        assertThat(stringList, hasItems(allOf(matchers)));
    }
}
