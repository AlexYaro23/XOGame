package com.game.xo.view;

import com.game.xo.model.Field;
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
        String nameRow = players[0].getName() + " vs " + players[1].getName();

        System.out.println(nameRow);
    }
}
