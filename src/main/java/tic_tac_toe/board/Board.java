package tic_tac_toe.board;

import tic_tac_toe.game.Symbol;

import java.util.ArrayList;
import java.util.List;



/**
 * Represents a game board for a tic-tac-toe-like game.
 * The Board class is responsible for managing the state of the game board,
 * performing operations related to game logic, and determining the winner.
 */
public class Board {
    /**
     * 2D array representing the cells of the board.
     */
    protected int[][] cells;

    /** Character representing the 'X' symbol */
    protected static final char X_CHAR = 'X';

    /** Character representing the 'O' symbol  */
    protected static final char O_CHAR = 'O';

    /** Character representing an empty cell on the board. */
    protected static final char EMPTY_CHAR = ' ';

    /** Numeric value representing the 'X' symbol in the cells array. */
    protected static final int X_NUM = 10;

    /** Numeric value representing the 'O' symbol  */
    protected static final int O_NUM = 100;

    /** Numeric value representing an empty cell  */
    protected static final int EMPTY_NUM = 0;

    /** The width of the board representing a 3x3 grid */
    private static final int BOARD_WIDTH = 3;

    /**
     * Constructor initializes the board, setting all cells to EMPTY_NUM
     */
    public Board() {
        cells = new int[BOARD_WIDTH][BOARD_WIDTH];
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                cells[i][j] = EMPTY_NUM;
            }
        }
    }

    /**
     * Checks if a specific cell is empty
     *
     * @param position The position to check
     * @return true if the cell is empty, false otherwise
     */
    public boolean isCellEmpty(Position position) {
        return cells[position.getX()][position.getY()] == Board.EMPTY_NUM;
    }

    /**
     * Sets a cell with a symbol  based on the given position and symbol
     *
     * @param position The position of the cell to set
     * @param symbol The symbol to set
     */
    public void setBySymbol(Position position, Symbol symbol) {
        if (symbol == Symbol.X) {
            this.setX(position);
        } else {
            this.setO(position);
        }
    }

    /**
     * Sets the specified cell to X_NUM, representing an X symbol
     *
     * @param position The position of the cell to set to X
     */
    public void setX(Position position) {
        cells[position.getX()][position.getY()] = Board.X_NUM;
    }

    /**
     * Sets the specified cell to O_NUM, representing an O symbol
     *
     * @param position The position of the cell to set to O
     */
    public void setO(Position position) {
        cells[position.getX()][position.getY()] = Board.O_NUM;
    }

    /**
     * Converts a numeric value from the cells array into its corresponding character
     *
     * @param num The numeric value from the cells array
     * @return The corresponding character
     */
    private char getChar(int num) {
        char symbol = EMPTY_CHAR;
        switch (num) {
            case X_NUM -> symbol = X_CHAR;
            case O_NUM -> symbol = O_CHAR;
            default -> {
                return symbol;
            }
        }
        return symbol;
    }

    /**
     * Determines the winner based on the sum of values in a row, column, or diagonal
     * If the sum equals three X_NUMs, X is the winner; if it equals three O_NUMs, O is the winner
     *
     * @param sum The sum of the values in a row, column, or diagonal
     * @return The winning symbol (X or O) or Symbol.NONE if there is no winner
     */
    private Symbol getWinnerFromSum(int sum) {
        if (sum == X_NUM * 3) {
            return Symbol.X;
        } else if (sum == O_NUM * 3) {
            return Symbol.O;
        }
        return Symbol.NONE;
    }

    /**
     * Checks if the board is full
     *
     * @return true if the board is full, false otherwise
     */
    public boolean isBoardFull() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (isCellEmpty(new Position(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the width of the board
     *
     * @return The width of the board
     */
    public int getBoardWidth() {
        return BOARD_WIDTH;
    }

    /**
     * Prints the current state of the board to the console
     */
    public void printBoard() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                System.out.print(" " + getChar(cells[i][j]));
                if (j < BOARD_WIDTH - 1) {
                    System.out.print(" |");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            if (i < BOARD_WIDTH - 1) {
                System.out.println("-----------");
            }
        }
    }

    /**
     * Determines the winner of the game by checking rows, columns, and diagonals
     *
     * @return The winning symbol (X or O) or Symbol.NONE if there is no winner
     */
    public Symbol getWinner() {
        if (getHorizontalWinner() != Symbol.NONE) {
            return getHorizontalWinner();
        }
        if (getVerticalWinner() != Symbol.NONE) {
            return getVerticalWinner();
        }
        if (getDiagonalWinner() != Symbol.NONE) {
            return getDiagonalWinner();
        }
        return Symbol.NONE;
    }

    /**
     * Checks if there is a winner on the board
     *
     * @return true if there is a winner, false otherwise
     */
    public boolean containsWinner() {
        return getHorizontalWinner() != Symbol.NONE || getDiagonalWinner() != Symbol.NONE || getVerticalWinner() != Symbol.NONE;
    }

    /**
     * Checks each row to see if there is a winner
     *
     * @return The winning symbol or Symbol.NONE if no winner is found
     */
    private Symbol getHorizontalWinner() {
        int sum = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                sum += cells[i][j];
            }
            if (getWinnerFromSum(sum) != Symbol.NONE) {
                return getWinnerFromSum(sum);
            }
            sum = 0;
        }
        return Symbol.NONE;
    }

    /**
     * Checks each column to see if there is a winner
     *
     * @return The winning symbol or Symbol.NONE if no winner is found
     */
    private Symbol getVerticalWinner() {
        int sum = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                sum += cells[j][i];
            }
            if (getWinnerFromSum(sum) != Symbol.NONE) {
                return getWinnerFromSum(sum);
            }
            sum = 0;
        }
        return Symbol.NONE;
    }

    /**
     * Checks both diagonals to see if there is a winner
     *
     * @return The winning symbol or Symbol.NONE if no winner is found
     */
    private Symbol getDiagonalWinner() {
        int sum = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            sum += cells[i][i];
        }
        if (getWinnerFromSum(sum) != Symbol.NONE) {
            return getWinnerFromSum(sum);
        }
        sum = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            sum += cells[BOARD_WIDTH - 1 - i][i];
        }
        if (getWinnerFromSum(sum) != Symbol.NONE) {
            return getWinnerFromSum(sum);
        }
        return Symbol.NONE;
    }

    /**
     * Gets a list of all empty positions on the board
     *
     * @return A list of positions that are currently empty
     */
    public List<Position> getListOfEmptyPositions() {
        List<Position> emptyPositionsList = new ArrayList<>();
        Position position;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                position = new Position(i, j);
                if (isCellEmpty(position)) {
                    emptyPositionsList.add(position);
                }
            }
        }
        return emptyPositionsList;
    }
}

