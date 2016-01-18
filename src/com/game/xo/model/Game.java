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
}
