package actestDemo.domain;

import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static actestDemo.domain.LightState.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LightStateTest {

    @Parameters
    public static List<Object[]> data() {
        return asList(new Object[][] {
                { "RED", RED },
                { "RED_YELLOW", RED_YELLOW },
                { "GREEN", GREEN },
                { "YELLOW", YELLOW },
                { "YELLOW_BLINK", UNKNOWN },
                { "INVALID_VALUE", UNKNOWN }
        });
    }

    private String stateName;
    private LightState state;

    public LightStateTest(String stateName, LightState state) {
        this.stateName = stateName;
        this.state = state;
    }

    @Test
    public void valueFor() {
        assertEquals(state, LightState.valueFor(stateName));
    }
}
