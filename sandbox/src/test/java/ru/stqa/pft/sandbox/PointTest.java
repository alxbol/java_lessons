package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void checkZeroDistance() {
        Point p1 = new Point();
        p1.x = 300;
        p1.y = 300;
        Point p2 = new Point();
        p2.x = 300;
        p2.y = 300;
        Assert.assertEquals(p1.distance(p1, p2), 0.0);
    }

    @Test
    public void positiveTest() {
        Point p1 = new Point();
        p1.x = 0;
        p1.y = 0;
        Point p2 = new Point();
        p2.x = 100;
        p2.y = 100;
        Assert.assertEquals(p1.distance(p1, p2), 141.4213562373095);
    }
}
