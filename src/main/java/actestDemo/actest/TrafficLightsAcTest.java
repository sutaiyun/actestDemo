/**
 * Created by sutaiyun on 2016/8/1.
 */

package actestDemo.actest;

import actestDemo.domain.LightState;

public class TrafficLightsAcTest {
    /*
    private String state;
    public void setPreviousStates(String state) {
        this.state = state;
    }

    public String nextStates() {
        if ("red".equals(state)) {
            return "red, yellow";
        }

        if ("red, yellow".equals(state)) {
            return "green";
        }

        if ("green".equals(state)) {
            return "yellow";
        }

        if ("yellow".equals(state)) {
            return "red";
        }

        return "yellow blink";
    }
    */

    private LightState state;

    public void setPreviousState(LightState state) {   /* 由LightStateEditor 将wiki上的string直接转成 LightState 对象 */
        this.state = state;
    }

    public LightState nextStates() {    /* 返回state对象， 然后由  LightStateEditor 转成了 string */
        return state.next();
    }
}
