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

        return "green";
    }
}
