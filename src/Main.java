import controllers.GameController;
import models.*;
import strategy.winningstrategy.OrderOneColumnWinningStrategy;
import strategy.winningstrategy.OrderOneDiagonalWinningStrategy;
import strategy.winningstrategy.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        Game game;

        game = gameController.createGame(3,
                List.of(
                        new Player(new Symbol('X'), "Naman", PlayerType.HUMAN),
                        new Bot(new Symbol('O'), "Aman", BotDifficultyLevel.EASY)
                ),
                List.of(new OrderOneColumnWinningStrategy(),
                        new OrderOneRowWinningStrategy(),
                        new OrderOneDiagonalWinningStrategy()));

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.displayBoard(game);
            System.out.println("Do you want to undo? (y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                gameController.undo(game);
            } else {
                // move next player
                gameController.makeMove(game);
            }
        }

        gameController.printResult(game);
    }
}