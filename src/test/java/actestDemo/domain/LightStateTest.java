package actestDemo.domain;

import static actestDemo.domain.LightState.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;


/**
 * Created by sutaiyun on 2016/8/2.
 */
@RunWith(Parameterized.class)
public class LightStateTest {

    @Parameters
    public static List<Object[]> data () {
        return asList(new Object[][]{
                //previous,   next
                { RED,           RED_YELLOW },
                { RED_YELLOW,    GREEN },
                { GREEN,         YELLOW },
                { YELLOW,        RED}
        });
    }

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    private LightState previousState;
    private LightState nextState;

    public LightStateTest(LightState previousState, LightState nextState) {
        this.previousState = previousState;
        this.nextState = nextState;
    }

    @Test
    public void testStateChange() {
//        assertEquals(RED_YELLOW, RED.next());
//        assertEquals(LightState.GREEN, RED_YELLOW.next());
        assertEquals(nextState, previousState.next());
    }
}