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
        boolean horizVert = horizontalVertical();
        int spaceCounter = 0;

        if(horizVert)
        {
            int rowNum = gen.nextInt(10);

            for(int col = 0; col < 10; col++)
            {
                if(board.getBoard()[rowNum][col] == 0)
                {
                    spaceCounter++;
                }
                if(spaceCounter >= ship1.getLength())
            }


        }
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
}
