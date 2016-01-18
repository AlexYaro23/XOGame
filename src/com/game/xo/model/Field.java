package com.game.xo.model;

import com.game.xo.exception.InvalidPointValuesException;
import com.game.xo.exception.NotNullFieldException;

public class Field
{
    static int FIELD_SIZE = 3;
    static int MIN_SIZE = 0;
    private Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public void addFigure(Point point, Figure figure)
            throws InvalidPointValuesException, NotNullFieldException
    {
        if (
            point.getX() >= FIELD_SIZE ||
            point.getX() < MIN_SIZE ||
            point.getY() >= FIELD_SIZE ||
            point.getY() < MIN_SIZE
        ) {
            throw new InvalidPointValuesException();
        }

        if (figures[point.getX()][point.getY()] != null) {
            throw new NotNullFieldException();
        }

        figures[point.getX()][point.getY()] = figure;
    }

    public Figure[][] getFigures()
    {
        return figures;
    }
}
