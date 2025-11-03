import java.util.Arrays;
import java.util.Objects;

public class BattleshipBoard
{
    private static final int ROW = 10;
    private static final int COL = 10;
    private double[][] board;

    public BattleshipBoard()
    {
        board = new double[ROW][COL];
        clearBoard();
    }

    public double[][] getBoard() {
        return board;
    }

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

    public void setIndex(int row, int col, double shipNum)
    {
        board[row][col] = shipNum;
    }

    public boolean isValidMove(int row, int col)
    {
        return board[row][col] != 1 && board[row][col] != 6 && board[row][col] != 7 && board[row][col] != 8 && board[row][col] != 9;
    }

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

    public boolean checkIfSunk(double shipLength, int shipHitNum, int row, int col)
    {
            if (board[row][col] != shipHitNum) {
                return false;
            }
            int consecCounter = 1;

            for (int consecCol = col - 1; consecCol >= 0 && board[row][consecCol] == shipHitNum && consecCounter < shipLength; consecCol--) {
                consecCounter++;
            }

            for (int consecCol = col + 1; consecCol < board[row].length && board[row][consecCol] == shipHitNum && consecCounter < shipLength; consecCol++) {
                consecCounter++;
            }

            if (consecCounter == shipLength) {
                return true;
            }

            consecCounter = 1;

            for (int consecRow = row - 1; consecRow >= 0 && board[consecRow][col] == shipHitNum && consecCounter < shipLength; consecRow--) {
                consecCounter++;
            }

            for (int consecRow = row + 1; consecRow < board.length && board[consecRow][col] == shipHitNum && consecCounter < shipLength; consecRow++) {
                consecCounter++;
            }

            if (consecCounter == shipLength) {
                return true;
            }

        return false;
    }

    @Override
    public String toString() {
        return "BattleshipBoard{" +
                "board=" + Arrays.toString(board) +
                '}';
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
