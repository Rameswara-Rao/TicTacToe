import controllers.GameController;
import exceptions.InvalidGameParamsException;
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

        List<Player> players = List.of(
                new Player(new Symbol('X'), "Naman", PlayerType.HUMAN),
                new Bot(new Symbol('O'), "Aman", BotDifficultyLevel.EASY)
        );
        int dimension = 3;

        try {
            game = gameController.createGame(dimension,
                    players,
                    List.of(new OrderOneColumnWinningStrategy(dimension, players),
                            new OrderOneRowWinningStrategy(dimension, players),
                            new OrderOneDiagonalWinningStrategy(players)));
        } catch (InvalidGameParamsException e){
            System.out.println("Seems like you gave invalid params. Updates Params");
            return;
        }

        System.out.println("*************** Game is Starting ********************");

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
        gameController.displayBoard(game);
    }
}