package controllers;

import exceptions.InvalidGameParamsException;
import models.Game;
import models.GameStatus;
import models.Player;
import strategy.winningstrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension,
                           List<Player> players,
                           List<WinningStrategy> winningStrategies) throws InvalidGameParamsException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setWinningStrategies(winningStrategies)
                .setPlayers(players)
                .build();
    }

    public void displayBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undo(Game game) {
        game.undo();
    }
    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }
    public void printResult(Game game){
        game.printResult();
    }
}