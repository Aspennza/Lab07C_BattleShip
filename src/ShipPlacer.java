import java.util.ArrayList;
import java.util.Random;

public class ShipPlacer
{
    BattleshipBoard board;
    Random gen;

    public ShipPlacer(BattleshipBoard board)
    {
        this.board = board;
        gen = new Random();
    }

    public void placeShip(Ship ship)
    {
        boolean horizVert1 = isHorizontal();
        ArrayList<Integer> possiblePlacements;
        int attempts = 0;

            if (horizVert1) {
                int rowNum;

                do {
                    rowNum = gen.nextInt(10);
                    possiblePlacements = validIndices(ship, horizVert1, rowNum);
                    attempts++;
                    if (attempts > 100) {
                        horizVert1 = !horizVert1;
                    }
                } while (possiblePlacements.isEmpty());

                int arrayIndex = gen.nextInt(possiblePlacements.size());
                int colNum = possiblePlacements.get(arrayIndex);

                for (int col = colNum; col < colNum + ship.getLength(); col++) {
                    board.setIndex(rowNum, col, ship.getLength());
                }
            } else {
                int colNum;

                do {
                    colNum = gen.nextInt(10);
                    possiblePlacements = validIndices(ship, horizVert1, colNum);
                    attempts++;
                    if (attempts > 100) {
                        horizVert1 = !horizVert1;
                    }
                } while (possiblePlacements.isEmpty());

                int arrayIndex = gen.nextInt(possiblePlacements.size());
                int rowNum = possiblePlacements.get(arrayIndex);

                for (int row = rowNum; row < rowNum + ship.getLength(); row++) {
                    board.setIndex(row, colNum, ship.getLength());
                }
            }
    }

    public boolean isHorizontal()
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

    public ArrayList<Integer> validIndices(Ship ship, boolean horizVert, int fixedIndex)
    {
        int spaceCounter = 0;
        ArrayList<Integer> validIndices = new ArrayList<Integer>();

        if(horizVert)
        {
            for(int col = 0; col <= 10 - ship.getLength(); col++)
            {
                spaceCounter = 0;
                if(board.getBoard()[fixedIndex][col] == 0)
                {
                    for(int consecCol = col; consecCol < col + ship.getLength(); consecCol++)
                    {
                        if(board.getBoard()[fixedIndex][consecCol] == 0)
                        {
                            spaceCounter++;
                        } else {
                            break;
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
            for(int row = 0; row <= 10 - ship.getLength(); row++)
            {
                spaceCounter = 0;
                if(board.getBoard()[row][fixedIndex] == 0)
                {
                    for(int consecRow = row; consecRow < row + ship.getLength(); consecRow++)
                    {
                        if(board.getBoard()[consecRow][fixedIndex] == 0)
                        {
                            spaceCounter++;
                        } else {
                            break;
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
