package com.game.xo.controller;

import com.game.xo.model.Field;
import com.game.xo.model.Game;
import com.game.xo.model.Player;
import com.game.xo.view.FieldView;

public class GameController
{
    private Game game;
    private FieldView field;

    public GameController(Player player1, Player player2)
    {
        game = new Game(new Player[]{player1, player2}, new Field());
        field = new FieldView(game.getField());
    }

    public void move()
    {
        field.showPlayers(game.getPlayers());
        field.showStep();
        field.showField();
    }

    public boolean checkWinner()
    {
        return false;
    }

    public void showWinner()
    {
        field.showPlayers(game.getPlayers());
        field.showField();
        field.showWinner();
    }
}
