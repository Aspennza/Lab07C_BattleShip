import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the BoardPnl.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class BoardPnlTest {

    //A BattleshipGame for testing the methods
    BattleshipGame game;

    //A BoardPnl for testing the methods
    BoardPnl pnl;

    @BeforeEach
    void setUp() {
        game = new BattleshipGame();
        pnl = new BoardPnl(game);
    }

    @Test
    void testConstructor() {
        assertNotNull(pnl.getGame());
        assertSame(game, pnl.getGame());
        assertNotNull(pnl.getBoardGUI());
        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                assertNotNull(pnl.getBoardGUI()[row][col]);
                assertEquals(row, pnl.getBoardGUI()[row][col].getRow());
                assertEquals(col, pnl.getBoardGUI()[row][col].getCol());
                assertEquals(pnl.getBoardGUI()[row][col].getBlankIcon(), (ImageIcon) pnl.getBoardGUI()[row][col].getIcon());
            }
        }

        int rows = ((GridLayout) pnl.getLayout()).getRows();
        int cols = ((GridLayout) pnl.getLayout()).getColumns();
        assertEquals(10, rows);
        assertEquals(10, cols);
    }
}