package tic_tac_toe.player;
import tic_tac_toe.game.Symbol;
import tic_tac_toe.board.Board;
import tic_tac_toe.board.Position;

import java.util.Scanner;


import java.util.Scanner;

/**
 * Represents a player in the game who interacts with the game through the console
 * The InteractivePlayer class allows a human player to input their move by selecting a box number on the board
 */
public class InteractivePlayer extends Player {

    /**
     * Constructs an InteractivePlayer with the specified symbol
     *
     * @param symbol The symbol (X or O) representing this player
     */
    public InteractivePlayer(Symbol symbol) {
        super(symbol);
    }

    /**
     * Prompts the player to make a move by entering a box number
     * The move is validated to ensure it is within the valid range and the selected cell is empty
     * The board is updated with the player's symbol once a valid move is made
     *
     * @param board The board on which the player makes a move
     */
    public void move(Board board) {
        Scanner scanner = new Scanner(System.in);
        Position potentialPosition = null;
        int numberIn = -1;
        boolean isValid = false;

        printSimplifiedBoardWithNumbers(board);
        System.out.println("Enter box number to select. Enjoy!\n");

        while (!isValid) {
            numberIn = scanner.nextInt();
            potentialPosition = Position.translateNumberInIntoPosition(numberIn, board.getBoardWidth());
            if (verifyIfIsNumberValid(numberIn, board.getBoardWidth() * board.getBoardWidth())
                    && board.isCellEmpty(potentialPosition)) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }

        board.setBySymbol(potentialPosition, symbol);
    }

    /**
     * Verifies if the entered box number is within the valid range
     *
     * @param numberIn The entered box number
     * @param max The maximum valid box number
     * @return true if the number is within the valid range, false otherwise
     */
    private static boolean verifyIfIsNumberValid(int numberIn, int max) {
        return numberIn >= 1 && numberIn <= max;
    }

    /**
     * Prints a simplified version of the board, displaying the box numbers instead of symbols
     * This helps the player to see the available options for their move
     *
     * @param board The board to be printed
     */
    private static void printSimplifiedBoardWithNumbers(Board board) {
        int k = 1;
        System.out.println();
        System.out.println();

        for (int i = 0; i < board.getBoardWidth(); i++) {
            for (int j = 0; j < board.getBoardWidth(); j++) {
                System.out.print(" " + k);
                if (j < board.getBoardWidth() - 1) {
                    System.out.print(" |");
                } else {
                    System.out.print("  ");
                }
                k++;
            }
            System.out.println();
            if (i < board.getBoardWidth() - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
        System.out.println();
    }
}

