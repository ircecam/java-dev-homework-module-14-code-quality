package tic_tac_toe.player;

import tic_tac_toe.game.Symbol;
import tic_tac_toe.board.Board;
import tic_tac_toe.board.Position;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Represents a player that makes random moves in the game of tic-tac-toe
 * The RandomPlayer class extends the Player class and selects a random empty position on the board for each move
 */
public class RandomPlayer extends Player {

    /**
     * Constructs a RandomPlayer with the specified symbol
     *
     * @param symbol The symbol (X or O) representing this player
     */
    public RandomPlayer(Symbol symbol) {
        super(symbol);
    }

    /**
     * Makes a move by randomly selecting an empty position on the board
     * The list of empty positions is shuffled, and a random position is chosen and filled with the player's symbol
     *
     * @param board The board on which the player makes a move
     */
    public void move(Board board) {
        List<Position> listOfEmptyPositions = board.getListOfEmptyPositions();
        Collections.shuffle(listOfEmptyPositions);  // Shuffle the list to randomize the order of positions
        int randomIndex = new Random().nextInt(listOfEmptyPositions.size());  // Select a random index
        board.setBySymbol(listOfEmptyPositions.get(randomIndex), symbol);  // Place the symbol in the randomly selected position
    }
}

