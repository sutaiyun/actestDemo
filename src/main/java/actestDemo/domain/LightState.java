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
    UNKNOWN("YELLOW_BLINK");

    public String stateName;
    private LightState(String stateName) {
        this.stateName = stateName;
    }

    private LightState() {
        this("");
    }

    //public abstract LightState next ();
    public LightState next () {
        return UNKNOWN;
    }

    public static LightState valueFor(String stateName) {
        for (LightState state : values()) {
            if (state.stateName.equals(stateName)) {
                return state;
            }
        }

        return UNKNOWN;
    }
}
