import java.util.Random;

public class ShipPlacer
{
    BattleshipBoard board;

    public ShipPlacer(BattleshipBoard board)
    {
        this.board = board;
        Ship ship1 = new Ship(5);
        Ship ship2 = new Ship(4);
        Ship ship3 = new Ship(3);
        Ship ship4 = new Ship(3);
        Ship ship5 = new Ship(2);


    }

    public void place()
    {
        boolean horizVert = horizontalVertical();

        if(horizVert)
        {

        }
    }

    public boolean horizontalVertical()
    {
        Random gen = new Random();
        int randomVal;

        randomVal = gen.nextInt(2);

        if(randomVal == 0)
        {
            return true;
        } else {
            return false;
        }
    }
}
