package actestDemo.actest;

import actestDemo.domain.LightState;

import java.beans.PropertyEditorSupport;

/**
 * Created by sutaiyun on 2016/8/2.
 */
public class LightStateEditor extends PropertyEditorSupport {
    public void setAsText(String stateName) {
        /*
        if ("RED".equals(stateName)) {
            setValue(LightState.RED);
            return;
        }
        setValue(LightState.RED_YELLOW);
        */

        /*
        for (LightState lightState : LightState.values()) {
            if (lightState.stateName.equals(stateName)) {
                setValue(lightState);
                return;
            }
        }

        setValue(LightState.UNKNOWN);
        */
        System.out.println("wiki StateName are: " + stateName);
        setValue(LightState.valueFor(stateName));   /* 从fitness的 wiki页面上  获取  stateName字符串， 然后 将这个字符串转成 state对象, value指 state对象 */
    }

    /* getValue() , return object
       this object create by String state
       so fitnesse can use String to set enum State
     */

    public String getAsText () {
        LightState state = (LightState) getValue ();    /* getValue 即为state对象 */
        System.out.println("state object StateName are: " + state.stateName);
        return state.stateName;
    }
}
