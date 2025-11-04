import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the ShipPlacer.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class ShipPlacerTest {

    //A ShipPlacer for testing the methods
    ShipPlacer placer;

    //A ShipPlacer for testing the methods
    ShipPlacer placer2;

    //A Ship for testing the methods
    Ship ship1;

    //A Ship for testing the methods
    Ship ship2;

    //A BattleshipBoard for testing the methods
    BattleshipBoard board;

    //A BattleshipBoard for testing the methods
    BattleshipBoard board2;

    @BeforeEach
    void setUp() {
        board = new BattleshipBoard();
        placer = new ShipPlacer(board);
        ship1 = new Ship(3, 3);
        ship2 = new Ship(5, 5);
        board2 = new BattleshipBoard();
        placer2 = new ShipPlacer(board2);
    }

    @Test
    void testConstructor() {
        assertNotNull(placer.getGen());
        assertNotNull(placer.getBoard());
        assertSame(board, placer.getBoard());
    }

    @Test
    void placeShip() {
        placer.placeShip(ship1);
        placer.placeShip(ship2);

        int found5 = 0;
        int found4 = 0;
        int found3 = 0;
        int found3_1 = 0;
        int found2 = 0;

        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                if(board.getBoard()[row][col] == 5)
                {
                    found5++;
                } else if (board.getBoard()[row][col] == 3) {
                    found3++;
                }
            }
        }

        assertEquals(5, found5);
        assertEquals(3, found3);
    }

    @Test
    void validIndices() {
        ArrayList<Integer> ship1Array = new ArrayList<>();
        ship1Array.add(0);
        ship1Array.add(1);
        ship1Array.add(2);
        ship1Array.add(3);
        ship1Array.add(4);
        ship1Array.add(5);
        ship1Array.add(6);
        ship1Array.add(7);
        assertEquals(ship1Array, placer.validIndices(ship1, true, 0));
    }

    @Test
    void testEquals() {
        assertTrue(placer.equals(placer));
        assertFalse(placer.equals(placer2));
    }

    @Test
    void testHashCode() {
        assertEquals(1652075596, placer.hashCode());
    }
}