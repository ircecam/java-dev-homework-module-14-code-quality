package tic_tac_toe.player;

import tic_tac_toe.board.Board;
import tic_tac_toe.game.Symbol;


/**
 * Represents an abstract player in the game of tic-tac-toe
 * The Player class serves as a base class for different types of players (e.g., interactive or automated).
 * Each player has a symbol (X or O) and must implement the move method to define how they make a move on the board
 */
public abstract class Player {

    /** The symbol (X or O) associated with this player. */
    protected Symbol symbol;

    /**
     * Constructs a Player with the specified symbol
     *
     * @param symbol The symbol (X or O) representing this player
     */
    protected Player(Symbol symbol) {
        this.symbol = symbol;
    }

    /**
     * Abstract method that defines how the player makes a move on the board
     * Subclasses must implement this method to specify the player's move behavior
     *
     * @param board The board on which the player makes a move
     */
    public abstract void move(Board board);
}

