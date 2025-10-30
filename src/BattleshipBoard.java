public class BattleshipBoard
{
    private static final int ROW = 10;
    private static final int COL = 10;
    private String[][] board;

    public BattleshipBoard()
    {
        board = new String[ROW][COL];
        clearBoard();
    }

    public String[][] getBoard() {
        return board;
    }

    public void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }
}
