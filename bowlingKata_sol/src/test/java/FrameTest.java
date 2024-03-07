import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class FrameTest {

    @Test
    public void createFrameTest() {
        Frame frame = new Frame('5', '5');
        Assertions.assertEquals(5, frame.getFirstRoll());
        Assertions.assertEquals(5, frame.getSecondRoll());
    }

    @Test
    public void spareFrameTest(){
        Frame frame = new Frame('5', '/', '5');
        Assertions.assertEquals(15, frame.getFrameScore());
    }
}