import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Allows the creation of objects for placing ships on a battleship board.
 * Calculates whether a ship will be horizontal or vertical, determines possible
 * placements, and selects one.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ShipPlacer
{
    //A BattleshipBoard object where the ships will be placed
    BattleshipBoard board;

    //A Random object for generating random numbers
    Random gen;

    public ShipPlacer(BattleshipBoard board)
    {
        this.board = board;
        gen = new Random();
    }

    /**
     * This method checks whether a ship is horizontal or vertical, checks its possible placements, and
     * places it on the board.
     * @param ship the ship to be placed on the board
     */
    public void placeShip(Ship ship)
    {
        boolean horizVert1 = isHorizontal();
        ArrayList<Integer> possiblePlacements;
        int attempts = 0;

            //This algorithm tests if a ship is horizontal or vertical
            if (horizVert1) {
                int rowNum;

                //This algorithm checks the possible placements of the ship
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

                //This algorithm sets the chosen indices to the ship's ID
                for (int col = colNum; col < colNum + ship.getLength(); col++) {
                    board.setIndex(rowNum, col, ship.getID());
                }
            } else {
                int colNum;

                //This algorithm checks the possible placements of the ship
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

                //This algorithm sets the chosen indices to the ship's ID
                for (int row = rowNum; row < rowNum + ship.getLength(); row++) {
                    board.setIndex(row, colNum, ship.getID());
                }
            }
    }

    /**
     * This method randomly generates a value representing whether to place a ship horizontally or vertically
     * @return a boolean representing horizontal (true) or vertical (false)
     */
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

    /**
     * This method calculates all the valid placements of a ship in a particular row or column.
     * @param ship the ship to be placed
     * @param horizVert whether the ship is horizontal or vertical
     * @param fixedIndex a pre-selected index limiting the placement of the ship
     * @return an ArrayList of possible starting positions for the ship
     */
    public ArrayList<Integer> validIndices(Ship ship, boolean horizVert, int fixedIndex)
    {
        int spaceCounter = 0;
        ArrayList<Integer> validIndices = new ArrayList<Integer>();

        //This algorithm checks if a ship is horizontal or vertical
        if(horizVert)
        {
            //This algorithm runs through the possible positions for the ship
            for(int col = 0; col <= 10 - ship.getLength(); col++)
            {
                spaceCounter = 0;

                //This algorithm checks that an index is blank
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
            //This algorithm runs through the possible positions for the ship
            for(int row = 0; row <= 10 - ship.getLength(); row++)
            {
                spaceCounter = 0;
                //This algorithm checks that an index is blank
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShipPlacer placer = (ShipPlacer) o;
        return Objects.equals(board, placer.board) && Objects.equals(gen, placer.gen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, gen);
    }

    public BattleshipBoard getBoard() {
        return board;
    }

    public Random getGen() {
        return gen;
    }
}
