package actestDemo.domain;

import static org.junit.Assert.*;
import org.junit.Test;

import actestDemo.actest.LightStateEditor;
import actestDemo.domain.LightState;

/**
 * Created by sutaiyun on 2016/8/2.
 */
public class LightStateEditorTest {
    private LightStateEditor editor = new LightStateEditor();

    @Test
    public void setEditor () {
        editor.setAsText("RED");
        assertEquals(LightState.RED, editor.getValue());
    }
}
