package com.game.xo.model;

import com.game.xo.exception.InvalidPointValuesException;
import com.game.xo.exception.NotNullFieldException;

public class Field
{
    public static int FIELD_SIZE = 3;
    public static int MIN_SIZE = 0;
    private Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public void addFigure(Point point, Figure figure)
            throws NotNullFieldException
    {
        if (figures[point.getX()][point.getY()] != null) {
            throw new NotNullFieldException();
        }

        figures[point.getX()][point.getY()] = figure;
    }

    public Figure[][] getFigures()
    {
        return figures;
    }

    public Figure getWhoesStep()
    {
        int x = 0;

        for (int i = Field.MIN_SIZE; i < Field.FIELD_SIZE; i++) {
            for (int j = Field.MIN_SIZE; j < Field.FIELD_SIZE; j++) {
                if (figures[i][j] != null) {
                    x++;
                }
            }
        }

        return x % 2 == 0? Figure.X : Figure.O;
    }
}
