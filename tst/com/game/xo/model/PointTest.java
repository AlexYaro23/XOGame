package com.game.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest
{
    @Test
    public void testSetGetPoint() throws Exception
    {
        final int inputValueX = 1;
        final int exceptedValueX = inputValueX;
        final int inputValueY = 2;
        final int exceptedValueY = inputValueY;


        final Point point = new Point(inputValueX, inputValueY);

        final int actualValueX = point.getX();
        final int actualValueY = point.getY();

        assertEquals(exceptedValueX, actualValueX);
        assertEquals(exceptedValueY, actualValueY);
    }
}