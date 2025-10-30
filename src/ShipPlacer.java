import java.util.ArrayList;
import java.util.Random;

public class ShipPlacer
{
    BattleshipBoard board;
    Random gen;
    Ship ship1;
    Ship ship2;
    Ship ship3;
    Ship ship4;
    Ship ship5;

    public ShipPlacer(BattleshipBoard board)
    {
        this.board = board;
        gen = new Random();
        ship1 = new Ship(5);
        ship2 = new Ship(4);
        ship3 = new Ship(3);
        ship4 = new Ship(3);
        ship5 = new Ship(2);


    }

    public void place()
    {

    }

    public boolean horizontalVertical()
    {
        int randomVal;

        randomVal = gen.nextInt(2);

        if(randomVal == 0)
        {
            //true represents horizontal
            return true;
        } else {
            //false represents vertical
            return false;
        }
    }

    public ArrayList<Integer> validIndices(Ship ship)
    {
        boolean horizVert = horizontalVertical();
        int spaceCounter = 0;
        ArrayList<Integer> validIndices = new ArrayList<Integer>();

        if(horizVert)
        {
            int rowNum = gen.nextInt(10);

            for(int col = 0; col <= 11 - ship.getLength(); col++)
            {
                spaceCounter = 0;
                if(board.getBoard()[rowNum][col] == 0)
                {
                    for(int consecCol = col; consecCol < col + ship.getLength(); consecCol++)
                    {
                        if(board.getBoard()[rowNum][consecCol] == 0)
                        {
                            spaceCounter++;
                        }
                    }
                    if(spaceCounter == ship.getLength())
                    {
                        validIndices.add(col);
                    }
                }
            }
        }else
        {
            int colNum = gen.nextInt(10);

            for(int row = 0; row <= 11 - ship.getLength(); row++)
            {
                spaceCounter = 0;
                if(board.getBoard()[row][colNum] == 0)
                {
                    for(int consecRow = row; consecRow < row + ship.getLength(); consecRow++)
                    {
                        if(board.getBoard()[consecRow][colNum] == 0)
                        {
                            spaceCounter++;
                        }
                    }
                    if(spaceCounter == ship.getLength())
                    {
                        validIndices.add(row);
                    }
                }
            }
        }
        return validIndices;
    }
}
