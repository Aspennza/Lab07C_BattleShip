import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class StatusPnlTest {

    StatusPnl pnl;

    @BeforeEach
    void setUp() {
        pnl = new StatusPnl();
    }

    @Test
    void testConstructor() {
        assertNotNull(pnl.getMissLbl());
        assertNotNull(pnl.getMissTF());
        assertNotNull(pnl.getStrikeTF());
        assertNotNull(pnl.getStrikeLbl());
        assertNotNull(pnl.getTotalHitLbl());
        assertNotNull(pnl.getTotalHitTF());
        assertNotNull(pnl.getTotalMissLbl());
        assertNotNull(pnl.getTotalMissTF());
        assertEquals("Misses:", pnl.getMissLbl().getText());
        assertEquals("Strikes:", pnl.getStrikeLbl().getText());
        assertEquals("Total Misses:", pnl.getTotalMissLbl().getText());
        assertEquals("Total Hits:", pnl.getTotalHitLbl().getText());
        assertEquals("0", pnl.getMissTF().getText());
        assertEquals("0", pnl.getStrikeTF().getText());
        assertEquals("0", pnl.getTotalMissTF().getText());
        assertEquals("0", pnl.getTotalHitTF().getText());
        int rows = ((GridLayout) pnl.getLayout()).getRows();
        int cols = ((GridLayout) pnl.getLayout()).getColumns();
        assertEquals(2, rows);
        assertEquals(4, cols);
    }
}