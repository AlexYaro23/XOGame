package com.game.xo.model;

public class Game
{
    private Player[] players;
    private Field field;

    public Game(Player[] players, Field field)
    {
        this.players = players;
        this.field = field;
    }

    public Player[] getPlayers()
    {
        return players;
    }

    public Field getField()
    {
        return field;
    }

    public Player getPlayerByFigure(Figure figure)
    {
        return players[0].getFigure() == figure ? players[0] : players[1];
    }
}
