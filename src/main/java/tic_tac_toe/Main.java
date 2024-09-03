package tic_tac_toe;

import tic_tac_toe.board.Board;
import tic_tac_toe.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Board());
        game.play();
    }
}
