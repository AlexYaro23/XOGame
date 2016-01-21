package com.game.xo.controller;

import com.game.xo.exception.NotNullFieldException;
import com.game.xo.model.*;
import com.game.xo.view.FieldView;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        Figure figure = game.getField().getWhoesStep();
        field.showStep(figure);
        field.showField();

        while (true) {
            int x = getCoord("x");
            int y = getCoord("y");

            try {
                game.getField().addFigure(new Point(x, y), figure);
            } catch (NotNullFieldException e) {
                System.out.println("This point is already used. Try other coordinates.");
                continue;
            }

            break;
        }
    }

    private int getCoord(String coordinateName)
    {
        int i;
        while (true) {
            System.out.print("Enter coordinate " + coordinateName + " :");
            Scanner scanner = new Scanner(System.in);
            try {
                i = scanner.nextInt();
                if (i < Field.MIN_SIZE || i >= Field.FIELD_SIZE) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter number from " + Field.MIN_SIZE + " to " + (Field.FIELD_SIZE - 1));
                continue;
            }

            return i;
        }
    }

    public boolean checkWinner()
    {
        Figure[][] figures = game.getField().getFigures();

        for (int i = Field.MIN_SIZE; i < Field.FIELD_SIZE; i++) {
            Figure fig = figures[i][Field.MIN_SIZE];
            if (fig == null) {
                continue;
            }
            boolean checker = true;
            for (int j = Field.MIN_SIZE; j < Field.FIELD_SIZE; j++) {
                if (fig != figures[i][j]) {
                    checker = false;
                }
            }

            if (checker == true) {
                return true;
            }
        }

        for (int i = Field.MIN_SIZE; i < Field.FIELD_SIZE; i++) {
            Figure fig = figures[Field.MIN_SIZE][i];
            if (fig == null) {
                continue;
            }
            boolean checker = true;
            for (int j = Field.MIN_SIZE; j < Field.FIELD_SIZE; j++) {
                if (fig != figures[j][i]) {
                    checker = false;
                }
            }

            if (checker == true) {
                return true;
            }
        }

        if (
            figures[Field.MIN_SIZE][Field.MIN_SIZE] == null ||
            figures[Field.MIN_SIZE][(Field.FIELD_SIZE - 1)] == null
        ) {
            return false;
        }

        Figure figure = figures[Field.MIN_SIZE][Field.MIN_SIZE];
        boolean checker1 = true;
        for (int i = Field.MIN_SIZE; i < Field.FIELD_SIZE; i++) {
            if (figure != figures[i][i]) {
                checker1 = false;
            }
        }

        if (checker1 == true) {
            return true;
        }

        Figure fig2 = figures[Field.MIN_SIZE][(Field.FIELD_SIZE - 1)];
        boolean checker2 = true;
        int i = Field.MIN_SIZE;
        for (int j = (Field.FIELD_SIZE - 1); j >= Field.MIN_SIZE; j--) {
            if (fig2 != figures[i][j]) {
                checker2 = false;
            }
            i++;
        }

        if (checker2 == true) {
            return true;
        }

        return false;
    }

    public void showWinner()
    {
        field.showPlayers(game.getPlayers());
        field.showField();

        if (checkLastMove()) {
            field.showNoWinner();
        } else {
            Figure figure = game.getField().getWhoesStep() == Figure.X ? Figure.O : Figure.X;
            Player player = game.getPlayerByFigure(figure);
            field.showWinner(player);
        }
    }

    public boolean checkLastMove()
    {
        Figure[][] figures = game.getField().getFigures();
        for (int i = Field.MIN_SIZE; i < Field.FIELD_SIZE; i++) {
            for (int j = Field.MIN_SIZE; j < Field.FIELD_SIZE; j++) {
                if (figures[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
