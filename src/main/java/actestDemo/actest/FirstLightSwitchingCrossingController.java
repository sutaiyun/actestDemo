package actestDemo.actest;

import actestDemo.domain.LightState;
import javafx.scene.effect.Light;

/**
 * Created by sutaiyun on 2016/8/7.
 */
public class FirstLightSwitchingCrossingController {
    private LightState firstLightState;
    private LightState secondLightState;

    public void setFirstLight(LightState state) {
        firstLightState = state;
    }

    public void setSecondLight(LightState state) {
        secondLightState = state;
    }

    public LightState firstLight() {
        return firstLightState;
    }
    public LightState secondLight() {
        return secondLightState;
    }

    public void execute() {
        /*
            该函数在由父类实现，在每个set之后被调用。
            这里实现 命令/查询分离模式 ,   即让firstLight()函数不是返回next， 而是返回当前状态。
         */
        if (!LightState.RED.equals(secondLightState)) {
            firstLightState = LightState.UNKNOWN;
            secondLightState = LightState.UNKNOWN;
            return ;
        }
        firstLightState = firstLightState.next();
    }
}
