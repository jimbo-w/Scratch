package datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class LinkedListTest {

    private LinkedList<String> list;

    @Before
    public void beforeEach() {
        list = new LinkedList<>();
    }

    @Test
    public void add() {
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        assertThat(list.toString(), is("{1,2,3,}"));

        list.addFirst("0");
        list.addFirst("-1");

        assertThat(list.toString(), is("{-1,0,1,2,3,}"));
    }

    @Test
    public void remove() {
        String value = list.removeFirst();
        assertThat(value, is(nullValue()));
        assertThat(value, is(nullValue()));

        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.removeLast();
        list.removeFirst();
        assertThat(list.toString(), is("{2,}"));

        value = list.remove("1");
        assertThat(value, is(nullValue()));

        list.remove("2");
        assertThat(list.toString(), is("{}"));
    }

    @Test(expected = NullPointerException.class)
    public void removeNullItem() {
        LinkedList<String> list = new LinkedList<>();
        list.remove(null);
    }
}
