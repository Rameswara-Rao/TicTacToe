package strategy.winningstrategy;

import models.Board;
import models.Move;

public class OrderOneDiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}