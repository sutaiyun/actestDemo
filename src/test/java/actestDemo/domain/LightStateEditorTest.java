package actestDemo.domain;

import static java.util.Arrays.asList;
import java.util.List;

import static actestDemo.domain.LightState.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import actestDemo.actest.LightStateEditor;

/**
 * Created by sutaiyun on 2016/8/2.
 */
@RunWith(Parameterized.class)
public class LightStateEditorTest {

    @Parameters
    public static List<Object[]> data() {
        return asList(new Object[][]{
                        {"RED", RED},
                        {"RED_YELLOW", RED_YELLOW},
                        {"GREEN", GREEN},
                        {"YELLOW", YELLOW},
                        {"YELLOW_BLINK", UNKNOWN}
                }
        );
    }
    /*
    private LightStateEditor editor = new LightStateEditor();

    @Test
    public void setEditor () {
        editor.setAsText("RED");
        assertEquals(RED, editor.getValue());
    }
    */

    private LightStateEditor editor = new LightStateEditor();
    private String stateName;
    private LightState state;

    public LightStateEditorTest(String stateName, LightState state) {
        this.stateName = stateName;
        this.state = state;
    }

    @Test
    public void setAsText () {
        editor.setAsText(stateName);                /* 模拟  网页wiki  设置 state 串 */
        assertEquals(state, editor.getValue());     /* editor 是从wiki 网页上获取的string，然后转化成state对象 */
    }

    @Test
    public void getAsText () {
        editor.setValue(state);      /*  设置状态， 状态也转化为stateName , 与setAsText相同都是 */
        assertEquals(stateName, editor.getAsText());        /* 获取 stateName */
    }
}
