package com.game.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest
{
    @Test
    public void testPlayerValues()
    {
        String inputName = "Alex";
        Figure inputFigure = Figure.X;
        String expectedName = inputName;
        Figure expectedFigure = inputFigure;

        Player player = new Player(inputName, inputFigure);

        String actualName = player.getName();
        Figure actualFigure = player.getFigure();

        assertEquals(expectedName, actualName);
        assertEquals(expectedFigure, actualFigure);
    }
}