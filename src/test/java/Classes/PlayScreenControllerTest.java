package Classes;

import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayScreenControllerTest {

    @Test
    public void testGetLineLength1() {

        Line line = new Line(0, 0, 3, 4);
        PlayScreenController object = new PlayScreenController();

        double result = object.getLineLength(line);
        assertEquals(5.0, result, 0.0001);
    }
    @Test
    public void testGetLineLength2() {

        Line line = new Line(-2, -3, 1, 2);
        PlayScreenController object = new PlayScreenController();

        double result = object.getLineLength(line);
        assertNotEquals(5.0, result, 0.0001);
    }
    @Test
    public void testGetLineLength3() {

        Line line = new Line(2, 2, 2, 2);
        PlayScreenController object = new PlayScreenController();

        double result = object.getLineLength(line);
        assertEquals(0, result, 0.0001);
    }


    @Test
    void testRotateStick1() {
        PlayScreenController object = new PlayScreenController();


        double x0 = 0.0;
        double y0 = 0.0;
        double x1 = 1.0;
        double y1 = 1.0;


        double[] result = object.rotateStick(1,x0, y0, x1, y1);


        double expectedX = x0 - (y1 - y0);
        double expectedY = y0 + (x1 - x0);
        double[] expected = {expectedX, expectedY};


        assertArrayEquals(expected, result, 0.0001);
    }
    @Test
    void testRotateStick2() {
        PlayScreenController object = new PlayScreenController();
        double x0 = 10.0;
        double y0 = 5.0;
        double x1 = 1.0;
        double y1 = 8.0;
        double[] result = object.rotateStick(1,x0, y0, x1, y1);
        double expectedX = x0 - (y1 - y0);
        double expectedY = y0 + (x1 - x0);
        double[] expected = {expectedX, expectedY};
        assertArrayEquals(expected, result, 0.0001);

    }




}