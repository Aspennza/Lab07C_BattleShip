import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class BattleshipButtonTest {

    BattleshipButton button1;

    @BeforeEach
    void setUp() {
        button1 = new BattleshipButton(1, 1);
    }

    @Test
    void testConstructor() {
        assertNotNull(button1.getRow());
        assertNotNull(button1.getCol());
        assertEquals(1, button1.getRow());
        assertEquals(1, button1.getCol());
        assertEquals("src/wave.png", button1.getBlankIcon().getDescription());
        assertEquals("src/miss.png", button1.getMissIcon().getDescription());
        assertEquals("src/hit.png", button1.getHitIcon().getDescription());
        assertTrue(button1.getBlank());
        assertFalse(button1.getMiss());
        assertFalse(button1.getHit());
        assertEquals(button1.getBlankIcon(), (ImageIcon) button1.getIcon());
        assertTrue(button1.isEnabled());
    }

    @Test
    void isBlank() {
        button1.isBlank();
        assertTrue(button1.getBlank());
        assertFalse(button1.getMiss());
        assertFalse(button1.getHit());
        assertEquals(button1.getBlankIcon(), (ImageIcon) button1.getIcon());
        assertTrue(button1.isEnabled());
    }

    @Test
    void isMiss() {
        button1.isMiss();
        assertTrue(button1.getMiss());
        assertFalse(button1.getBlank());
        assertFalse(button1.getHit());
        assertEquals(button1.getMissIcon(), (ImageIcon) button1.getIcon());
        assertFalse(button1.isEnabled());
    }

    @Test
    void isHit() {
        button1.isHit();
        assertTrue(button1.getHit());
        assertFalse(button1.getMiss());
        assertFalse(button1.getBlank());
        assertEquals(button1.getHitIcon(), (ImageIcon) button1.getIcon());
        assertFalse(button1.isEnabled());
    }
}