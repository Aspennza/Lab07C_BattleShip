public class Main
{
    public static void main(String[] args)
    {
        BattleshipBoard board = new BattleshipBoard();
        Ship ship1 = new Ship(5);
        Ship ship2 = new Ship(4);
        Ship ship3 = new Ship(3);
        Ship ship4 = new Ship(3);
        Ship ship5 = new Ship(2);

        ShipPlacer placer = new ShipPlacer(board);
        placer.placeShip(ship1);
        placer.placeShip(ship2);
        placer.placeShip(ship3);
        placer.placeShip(ship4);
        placer.placeShip(ship5);

        for(int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++) {
                System.out.print(board.getBoard()[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}