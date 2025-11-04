import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the BattleshipGame.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class BattleshipGameTest {

    //A BattleshipGame for testing the methods
    BattleshipGame game1;

    //A BattleshipGame for testing the methods
    BattleshipGame game2;

    @BeforeEach
    void setUp() {
        game1 = new BattleshipGame();
        game2 = new BattleshipGame();
    }

    @Test
    void startGame() {
        game1.startGame();
        assertNotNull(game1.getFrame());
        game1.getFrame().setVisible(false);
        assertNotNull(game1.getBoard());
        assertNotNull(game1.getPlacer());
        assertNotNull(game1.getTitlePnl());
        assertNotNull(game1.getBoardPnl());
        assertNotNull(game1.getStatusPnl());
        assertNotNull(game1.getControlPnl());
        assertTrue(game1.isPlaying());

        int found5 = 0;
        int found4 = 0;
        int found3 = 0;
        int found3_1 = 0;
        int found2 = 0;

        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                if(game1.getBoard().getBoard()[row][col] == 5)
                {
                    found5++;
                } else if(game1.getBoard().getBoard()[row][col] == 4) {
                    found4++;
                } else if (game1.getBoard().getBoard()[row][col] == 3) {
                    found3++;
                } else if(game1.getBoard().getBoard()[row][col] == 3.1) {
                    found3_1++;
                } else if (game1.getBoard().getBoard()[row][col] == 2){
                    found2++;
                }
            }
        }

        assertEquals(5, found5);
        assertEquals(4, found4);
        assertEquals(3, found3);
        assertEquals(3, found3_1);
        assertEquals(2, found2);
    }

    @Test
    void checkShipsSunk() {
        game1.setBoard(new BattleshipBoard());

        game1.getBoard().getBoard()[0][0] = 7;
        game1.getBoard().getBoard()[0][1] = 7;
        game1.getBoard().getBoard()[0][2] = 7;

        game1.getBoard().getBoard()[3][3] = 2;
        game1.getBoard().getBoard()[3][4] = 6;

        game1.getBoard().getBoard()[1][0] = 10;
        game1.getBoard().getBoard()[1][1] = 10;
        game1.getBoard().getBoard()[1][2] = 10;

        game1.getBoard().getBoard()[7][0] = 9;
        game1.getBoard().getBoard()[7][1] = 9;
        game1.getBoard().getBoard()[7][2] = 5;
        game1.getBoard().getBoard()[7][3] = 9;
        game1.getBoard().getBoard()[7][4] = 9;

        game1.getBoard().getBoard()[9][0] = 8;
        game1.getBoard().getBoard()[9][1] = 4;
        game1.getBoard().getBoard()[9][2] = 8;
        game1.getBoard().getBoard()[9][3] = 4;

        game1.checkShipsSunk(0, 0);
        game1.checkShipsSunk(3, 3);
        game1.checkShipsSunk(1, 1);
        game1.checkShipsSunk(7, 1);
        game1.checkShipsSunk(9, 3);

        assertTrue(game1.isShip3Sunk());
        assertFalse(game1.isShip5Sunk());
        assertTrue(game1.isShip4Sunk());
        assertFalse(game1.isShip1Sunk());
        assertFalse(game1.isShip2Sunk());
    }

    @Test
    void checkWin() {
        game1.startGame();
        game1.getFrame().setVisible(false);
        game1.checkWin();
        assertTrue(game1.isPlaying());
        game1.setShip1Sunk(true);
        game1.setShip2Sunk(true);
        game1.setShip3Sunk(true);
        game1.setShip4Sunk(true);
        game1.setShip5Sunk(true);
        game1.checkWin();
        assertFalse(game1.isPlaying());
    }

    @Test
    void checkLose() {
        game1.startGame();
        game1.getFrame().setVisible(false);
        game1.checkLose();
        assertTrue(game1.isPlaying());
        game1.setStrikes(3);
        game1.checkLose();
        assertFalse(game1.isPlaying());
    }

    @Test
    void generateFrame() {
        game1.generateFrame();
        game1.getFrame().setVisible(false);
        assertNotNull(game1.getFrame());
        assertEquals("Battleship", game1.getFrame().getTitle());
        assertEquals(JFrame.EXIT_ON_CLOSE, game1.getFrame().getDefaultCloseOperation());
        assertNotNull(game1.getTitlePnl());
        assertNotNull(game1.getBoardPnl());
        assertNotNull(game1.getStatusPnl());
        assertNotNull(game1.getControlPnl());
    }

    @Test
    void clearBoard() {
        game1.startGame();
        game1.getFrame().setVisible(false);
        game1.clearBoard();
        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                assertTrue(game1.getBoardPnl().getBoardGUI()[row][col].getBlank());
            }
        }
        assertTrue(game1.isPlaying());

        int found5 = 0;
        int found4 = 0;
        int found3 = 0;
        int found3_1 = 0;
        int found2 = 0;

        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                if(game1.getBoard().getBoard()[row][col] == 5)
                {
                    found5++;
                } else if(game1.getBoard().getBoard()[row][col] == 4) {
                    found4++;
                } else if (game1.getBoard().getBoard()[row][col] == 3) {
                    found3++;
                } else if(game1.getBoard().getBoard()[row][col] == 3.1) {
                    found3_1++;
                } else if (game1.getBoard().getBoard()[row][col] == 2){
                    found2++;
                }
            }
        }

        assertEquals(5, found5);
        assertEquals(4, found4);
        assertEquals(3, found3);
        assertEquals(3, found3_1);
        assertEquals(2, found2);

        assertEquals(0, game1.getMisses());
        assertEquals(0, game1.getTotalHits());
        assertEquals(0, game1.getTotalMisses());
        assertEquals(0, game1.getStrikes());
        assertFalse(game1.isShip1Sunk());
        assertFalse(game1.isShip2Sunk());
        assertFalse(game1.isShip3Sunk());
        assertFalse(game1.isShip4Sunk());
        assertFalse(game1.isShip5Sunk());
    }

    @Test
    void testEquals() {
        assertTrue(game1.equals(game2));
        game1.startGame();
        game1.getFrame().setVisible(false);
        game2.startGame();
        game2.getFrame().setVisible(false);
        assertFalse(game1.equals(game2));
    }

    @Test
    void testHashCode() {
        assertEquals(-1390077300, game1.hashCode());
        game1.startGame();
        game1.getFrame().setVisible(false);
        assertNotEquals(-1390077300, game1.hashCode());
    }
}