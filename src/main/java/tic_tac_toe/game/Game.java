package tic_tac_toe.game;

import tic_tac_toe.board.Board;
import tic_tac_toe.player.InteractivePlayer;
import tic_tac_toe.player.Player;
import tic_tac_toe.player.RandomPlayer;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game of tic-tac-toe
 */
public class Game {

    /** The game board on which the game is played */
    private Board board;

    /** The list of players participating in the game */
    private List<Player> players;

    /**
     * Constructs a new Game with a given board and initializes the players
     * The first player uses the X symbol and is an interactive player
     * The second player uses the O symbol and is a random player.
     *
     * @param board The board on which the game will be played
     */
    public Game(Board board) {
        this.board = board;
        this.players = new ArrayList<>();
        this.players.add(new InteractivePlayer(Symbol.X));
        this.players.add(new RandomPlayer(Symbol.O));
    }

    /**
     * Starts the game loop, where players take turns until the game ends
     * The game continues until the board is full or a player wins
     * After each move, the board is printed to the console
     * Once the game ends, the winner is announced
     */
    public void play() {
        while (!isGameEnded()) {
            for (Player player : players) {
                player.move(board);
                board.printBoard();
                System.out.println();
                if (isGameEnded()) {
                    break;
                }
            }
        }
        printWinner(board.getWinner());
    }

    /**
     * Checks if the game has ended
     * The game ends when the board is full or a player has won
     *
     * @return true if the game has ended, false otherwise
     */
    private boolean isGameEnded() {
        return this.board.isBoardFull() || this.board.containsWinner();
    }

    /**
     * Prints the result of the game to the console based on the winning symbol
     * If X wins, a victory message is displayed. If O wins, a defeat message is displayed
     * If there is no winner, a draw message is displayed
     *
     * @param symbol The symbol of the winning player, or Symbol.NONE if the game is a draw
     */
    private void printWinner(Symbol symbol) {
        if (symbol == Symbol.O) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (symbol == Symbol.X) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}

