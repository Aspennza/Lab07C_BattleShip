import java.util.Arrays;
import java.util.Objects;

/**
 * Allows the creation of objects representing the logic of a Battleship board.
 * Contains rows, columns, and a final array of doubles representing the board indices.
 * Also includes methods for acting on, updating, and comparing BattleshipBoard objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class BattleshipBoard
{
    //This int permanently stores the number of rows on the Battleship board
    private static final int ROW = 10;

    //This int permanently stores the number of columns on the Battleship board
    private static final int COL = 10;

    //This double array represents the 10 by 10 board used for Battleship
    private double[][] board;

    //This constructor establishes the board and fills it with empty spaces
    public BattleshipBoard()
    {
        board = new double[ROW][COL];
        clearBoard();
    }

    public double[][] getBoard() {
        return board;
    }

    /**
     * Sets all indices in the board to 0, representing a blank (non-miss and non-hit) space in battleship
     */
    public void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                //0 will represent blank cell, 1 will represent miss, 6,7,8,9, and 10 will represent a hit for each ship
                board[row][col] = 0;
            }
        }
    }

    /**
     * Sets the provided row and column index on the board to the provided ship ID number, thus placing part of the ship on that space
     * @param row the selected row location
     * @param col the selected column location
     * @param shipNum the ship's ID number
     */
    public void setIndex(int row, int col, double shipNum)
    {
        board[row][col] = shipNum;
    }

    /**
     * Tests if a player's selected move location is valid by determining whether the slot on the board is blank, a miss, or a hit
     * @param row the player's selected row for their move
     * @param col the player's selected column for their move
     * @return a boolean representing whether the player's move choice is valid
     */
    public boolean isValidMove(int row, int col)
    {
        return board[row][col] != 1 && board[row][col] != 6 && board[row][col] != 7 && board[row][col] != 8 && board[row][col] != 9;
    }

    /**
     * Determines what value to set a given index to depending on its current value (blank or a specific ship's value)
     * @param row the player's chosen row location for their move
     * @param col the player's chosen column location for their move
     * @return a boolean representing whether the move resulted in a miss or a hit
     */
    public boolean calculateMove(int row, int col)
    {
        if(board[row][col] == 0)
        {
            board[row][col] = 1;
            //false represents a miss
            return false;
        } else if(board[row][col] == 2){
            board[row][col] = 6;
            //true represents a hit
            return true;
        } else if(board[row][col] == 3) {
            board[row][col] = 7;
            return true;
        } else if(board[row][col] == 4) {
            board[row][col] = 8;
            return true;
        } else if(board[row][col] == 5){
            board[row][col] = 9;
            return true;
        } else {
            board[row][col] = 10;
            return true;
        }
    }

    /**
     * Checks if a specific ship has been sunk by checking up, down, left, and right for its assigned "sunk" value; if all the tiles in the ship are sunk, it returns true
     * @param shipLength the length of the ship being checked
     * @param shipHitNum the value representing a "sunk" index for that specific ship
     * @param row the row location of the player's move
     * @param col the column location of the player's move
     * @return a boolean representing whether the ship was sunk
     */
    public boolean checkIfSunk(double shipLength, int shipHitNum, int row, int col)
    {
            if (board[row][col] != shipHitNum) {
                return false;
            }
            int consecCounter = 1;

            //checking to the left
            for (int consecCol = col - 1; consecCol >= 0 && board[row][consecCol] == shipHitNum && consecCounter < shipLength; consecCol--) {
                consecCounter++;
            }

            //checking to the right
            for (int consecCol = col + 1; consecCol < board[row].length && board[row][consecCol] == shipHitNum && consecCounter < shipLength; consecCol++) {
                consecCounter++;
            }

            if (consecCounter == shipLength) {
                return true;
            }

            consecCounter = 1;

            //checking to the north
            for (int consecRow = row - 1; consecRow >= 0 && board[consecRow][col] == shipHitNum && consecCounter < shipLength; consecRow--) {
                consecCounter++;
            }

            //checking to the south
            for (int consecRow = row + 1; consecRow < board.length && board[consecRow][col] == shipHitNum && consecCounter < shipLength; consecRow++) {
                consecCounter++;
            }

            if (consecCounter == shipLength) {
                return true;
            }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BattleshipBoard that = (BattleshipBoard) o;
        return Objects.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
