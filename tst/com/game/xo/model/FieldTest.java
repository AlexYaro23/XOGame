package com.game.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest
{
    @Test
    public void testField() throws Exception
    {
        int inputX = 1;
        int inputY = 2;
        Point inputPoint = new Point(inputX, inputY);
        Figure inputFigure = Figure.X;
        Figure expectedFigure = inputFigure;

        Field field = new Field();
        field.addFigure(inputPoint, inputFigure);
        Figure[][] figures = field.getFigures();

        for (int i = 0; i < Field.FIELD_SIZE; i++) {
            for (int j = 0; j < Field.FIELD_SIZE; j++) {
                if (i == inputX && j == inputY) {
                    Figure actualFigure = figures[i][j];
                    assertEquals(expectedFigure, actualFigure);
                }
            }
        }
    }
}