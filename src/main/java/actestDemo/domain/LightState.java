package actestDemo.domain;

import javafx.scene.effect.Light;

/**
 * Created by sutaiyun on 2016/8/1.
 */
public enum LightState {
    RED {
        public LightState next () {
            return null;
        }
    },
    RED_YELLOW {
        public LightState next () {
            return null;
        }
    };

    public abstract LightState next ();
}
