package actestDemo.domain;

import javafx.scene.effect.Light;

/**
 * Created by sutaiyun on 2016/8/1.
 */
public enum LightState {
    RED {
        public LightState next () {
            return RED_YELLOW;
        }
    },
    RED_YELLOW {
        public LightState next () {
            return GREEN;
        }
    },
    GREEN {
        public LightState next () {
            return YELLOW;
        }
    },
    YELLOW {
        public LightState next() {
        return RED;
        }
    },
    UNKNOWN;

    //public abstract LightState next ();
    public LightState next () {
        return UNKNOWN;
    }
}
