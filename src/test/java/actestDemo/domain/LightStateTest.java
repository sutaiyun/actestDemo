package actestDemo.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by sutaiyun on 2016/8/2.
 */
public class LightStateTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStateChange() {
        assertEquals(LightState.RED_YELLOW, LightState.RED.next());
        assertEquals(LightState.GREEN, LightState.RED_YELLOW.next());
    }
}