package actestDemo.actest;

import actestDemo.domain.LightState;
import javafx.scene.effect.Light;

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
        setValue(LightState.valueFor(stateName));
    }

    /* getValue() , return object
       this object create by String state
       so fitnesse can use String to set enum State
     */

    public String getAsText () {
        LightState state = (LightState) getValue ();    /* getValue 即为state对象 */
        return state.stateName;
    }
}
