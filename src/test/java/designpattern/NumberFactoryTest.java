package designpattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static designpattern.NumberFactory.NumberType.*;

/**
 * Having a go with parametrised junit tests
 */
@RunWith(Parameterized.class)
public class NumberFactoryTest {
    private static Logger logger = LoggerFactory.getLogger(NumberFactoryTest.class);

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {INT, Integer.TYPE}, {DOUBLE, Double.TYPE}
        });
    }

    private final NumberFactory.NumberType type;
    private final Class clazz;

    public NumberFactoryTest(NumberFactory.NumberType type, Class clazz) {

        this.type = type;
        this.clazz = clazz;
    }

    @Test
    public void test() {
        logger.debug("type: {}; class {};", type.name(), clazz.getCanonicalName());
        assertThat(NumberFactory.createNumber(type), instanceOf(clazz));
    }
}
