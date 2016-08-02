package actestDemo.domain;

import javafx.scene.effect.Light;

/**
 * Created by sutaiyun on 2016/8/1.
 */
public enum LightState {
    RED("RED") {
        public LightState next () {
            return RED_YELLOW;
        }
    },
    RED_YELLOW("RED_YELLOW") {
        public LightState next () {
            return GREEN;
        }
    },
    GREEN("GREEN") {
        public LightState next () {
            return YELLOW;
        }
    },
    YELLOW("YELLOW") {
        public LightState next() {
        return RED;
        }
    },
    UNKNOWN("UNKNOWN");

    public String stateName;
    private LightState(String stringName) {
        this.stateName = stringName;
    }

    //public abstract LightState next ();
    public LightState next () {
        return UNKNOWN;
    }
}
