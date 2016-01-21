import com.game.xo.controller.GameController;
import com.game.xo.model.Figure;
import com.game.xo.model.Player;

public class Main
{
    public static void main(String[] args)
    {
        Player player1 = new Player("alex", Figure.X);
        Player player2 = new Player("bot", Figure.O);

        GameController game = new GameController(player1, player2);

        while (game.checkWinner() != true && game.checkLastMove() == false) {
            game.move();
        }

        game.showWinner();
    }
}
