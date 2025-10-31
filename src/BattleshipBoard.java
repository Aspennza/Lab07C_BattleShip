import java.util.Arrays;

public class BattleshipBoard
{
    private static final int ROW = 10;
    private static final int COL = 10;
    private int[][] board;

    public BattleshipBoard()
    {
        board = new int[ROW][COL];
        clearBoard();
    }

    public int[][] getBoard() {
        return board;
    }

    public void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                //0 will represent blank cell, 1 will represent miss, 6 will represent hit
                board[row][col] = 0;
            }
        }
    }

    public void setIndex(int row, int col, int shipNum)
    {
        board[row][col] = shipNum;
    }

    public boolean isValidMove(int row, int col)
    {
        return board[row][col] == 0;
    }

    public void setMiss(int row, int col)
    {

    }

    @Override
    public String toString() {
        return "BattleshipBoard{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
