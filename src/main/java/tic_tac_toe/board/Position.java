package tic_tac_toe.board;

/**
 * Represents a position on a 2D game board
 * The Position class is used to store and manage the coordinates (x, y) of a cell on the board
 */
public class Position {
    /** The x-coordinate of the position. */
    private int x;

    /** The y-coordinate of the position. */
    private int y;

    /**
     * Constructs a Position with the specified x and y coordinates
     *
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this position
     *
     * @return The x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of this position
     *
     * @return The y-coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Translates a one-dimensional index into a two-dimensional position based on the board width
     * This method is useful for converting linear array indices into 2D coordinates on a board
     *
     * @param numberIn The one-dimensional index
     * @param boardWidth The width of the board
     * @return A Position object representing the corresponding x and y coordinates
     */
    public static Position translateNumberInIntoPosition(int numberIn, int boardWidth) {
        int x = 0;
        int y = 0;
        int n = 1;
        while (numberIn > n) {
            if (n % boardWidth == 0) {
                x++;
                y = 0;
            } else {
                y++;
            }
            n++;
        }
        return new Position(x, y);
    }

    /**
     * Returns a string representation of the position
     *
     * @return A string in the format "(x, y)"
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

