/**
 * Created by sutaiyun on 2016/8/1.
 */

package actestDemo.actest;

public class TrafficLightsAcTest {
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
}
