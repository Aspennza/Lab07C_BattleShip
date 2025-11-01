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
                //0 will represent blank cell, 1 will represent miss, 6,7,8, and 9 will represent a hit for each ship
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
        }
    }

    public boolean checkIfSunk(Ship ship, int row, int col)
    {
        int shipNum = checkShipSinkNum(ship);

        if(board[row][col] != shipNum)
        {
            return false;
        }
        int consecCounter = 1;

        for(int consecCol = col - 1; consecCol >= 0 && board[row][consecCol] == shipNum; consecCol--)
        {
            consecCounter++;
        }

        for(int consecCol = col + 1; consecCol < board[row].length && board[row][consecCol] == shipNum; consecCol++)
        {
            consecCounter++;
        }

        if(consecCounter == ship.getLength())
        {
            return true;
        }

        consecCounter = 1;

        for(int consecRow = row - 1; consecRow >= 0 && board[consecRow][col] == shipNum; consecRow--) {
            consecCounter++;
        }

        for(int consecRow = row + 1; consecRow < board.length && board[consecRow][col] == shipNum; consecRow++) {
            consecCounter++;
        }

        if(consecCounter == ship.getLength()) {
            return true;
        }

        return false;
    }

    private int checkShipSinkNum(Ship ship)
    {
        if(ship.getLength() == 5) {
            return 9;
        } else if(ship.getLength() == 4) {
            return 8;
        } else if(ship.getLength() == 3) {
            return 7;
        } else {
            return 6;
        }
    }

    @Override
    public String toString() {
        return "BattleshipBoard{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
