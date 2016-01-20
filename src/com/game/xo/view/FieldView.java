package com.game.xo.view;

import com.game.xo.model.Field;
import com.game.xo.model.Figure;
import com.game.xo.model.Player;

public class FieldView
{
    private Field field;

    public FieldView(Field field)
    {
        this.field = field;
    }

    public void showPlayers(Player[] players)
    {
        String nameRow = players[0].getName() + "(" + players[0].getFigure().toString() + ")" + " vs " +
                players[1].getName() + "(" + players[1].getFigure().toString() + ")";

        System.out.println(nameRow);
    }

    public void showField()
    {
        Figure[][] figures =field.getFigures();
        for (int i = Field.MIN_SIZE; i < Field.FIELD_SIZE; i++) {
            for (int j = Field.MIN_SIZE; j < Field.FIELD_SIZE; j++) {

                String elem = " ";
                if (figures[i][j] != null) {
                    elem = figures[i][j].toString();
                }

                System.out.print(" " + elem + " ");
                if (j != Field.FIELD_SIZE - 1) {
                    System.out.print("|");
                }

            }

            if (i != Field.FIELD_SIZE - 1) {
                System.out.println("\n~~~~~~~~~~~");
            }
        }
    }

    public void showWinner()
    {

    }

    public void showStep()
    {
        System.out.println("Waiting for: " + field.getWhoesStep());
    }
}
