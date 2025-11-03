import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    Ship ship1;
    Ship ship2;
    Ship ship3;

    @BeforeEach
    void setUp() {
        ship1 = new Ship(3, 3);
        ship2 = new Ship(4, 4);
        ship3 = new Ship(3, 3);
    }

    @Test
    void testConstructor() {
        assertNotNull(ship1.getLength());
        assertNotNull(ship1.getID());
    }

    @Test
    void testEquals() {
        assertTrue(ship1.equals(ship1));
        assertTrue(ship1.equals(ship3));
        assertFalse(ship1.equals(ship2));
    }

    @Test
    void testHashCode() {
        assertEquals(1074267166, ship1.hashCode());
        assertEquals(1074791485, ship2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Ship{length=4, ID=4.0}", ship2.toString());
    }
}