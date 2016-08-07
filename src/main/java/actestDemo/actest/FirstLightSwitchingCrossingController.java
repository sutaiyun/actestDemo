package actestDemo.actest;

import actestDemo.domain.LightState;

/**
 * Created by sutaiyun on 2016/8/7.
 */
public class FirstLightSwitchingCrossingController {
    private LightState firstLightState;

    public void setFirstLight(LightState state) {
        firstLightState = state;
    }

    public void setSecondLight(LightState state) {
        //not use now!!!!!!
    }

    public LightState firstLight() {
        return firstLightState.next();
    }
    public LightState secondLight() {
        return LightState.RED;
    }
}
