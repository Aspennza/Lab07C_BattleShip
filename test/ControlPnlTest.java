import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ControlPnlTest {

    ControlPnl pnl;
    BattleshipGame game;

    @BeforeEach
    void setUp() {
        game = new BattleshipGame();
        pnl = new ControlPnl(game);
    }

    @Test
    void testConstructor() {
        assertNotNull(pnl.getGame());
        assertSame(game, pnl.getGame());
        assertNotNull(pnl.getPlayAgainBtn());
        assertNotNull(pnl.getQuitBtn());
        assertEquals("Play Again", pnl.getPlayAgainBtn().getText());
        assertEquals("Quit", pnl.getQuitBtn().getText());
        int rows = ((GridLayout) pnl.getLayout()).getRows();
        int cols = ((GridLayout) pnl.getLayout()).getColumns();
        assertEquals(1, rows);
        assertEquals(2, cols);
    }
}