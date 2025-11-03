import static org.junit.jupiter.api.Assertions.*;

class BattleshipBoardTest {

    BattleshipBoard board1;
    BattleshipBoard board2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        board1 = new BattleshipBoard();
        board2 = new BattleshipBoard();
    }

    @org.junit.jupiter.api.Test
    void testConstructor()
    {
        assertNotNull(board1.getBoard());
        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                assertEquals(0, board1.getBoard()[row][col]);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void clearBoard()
    {
        board1.getBoard()[0][0] = 5;
        board1.getBoard()[1][1] = 7;
        board1.clearBoard();
        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                assertEquals(0, board1.getBoard()[row][col]);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void setIndex()
    {
        board1.setIndex(1, 1, 3.1);
        assertEquals(3.1, board1.getBoard()[1][1]);
    }

    @org.junit.jupiter.api.Test
    void isValidMove() {
        board1.setIndex(1, 1, 9);
        board1.setIndex(1, 2, 8);
        board1.setIndex(1, 3, 7);
        board1.setIndex(1, 4, 6);
        board1.setIndex(1, 5, 1);
        assertTrue(board1.isValidMove(0, 0));
        assertFalse(board1.isValidMove(1, 1));
        assertFalse(board1.isValidMove(1, 2));
        assertFalse(board1.isValidMove(1, 3));
        assertFalse(board1.isValidMove(1, 4));
        assertFalse(board1.isValidMove(1, 5));
    }

    @org.junit.jupiter.api.Test
    void calculateMove() {
        assertFalse(board1.calculateMove(0,0));
        assertEquals(1, board1.getBoard()[0][0]);

        board1.setIndex(1, 1, 2);
        board1.setIndex(1, 2, 3);
        board1.setIndex(1, 3, 4);
        board1.setIndex(1, 4, 5);
        board1.setIndex(1, 5, 3.1);

        assertTrue(board1.calculateMove(1, 1));
        assertEquals(6, board1.getBoard()[1][1]);

        assertTrue(board1.calculateMove(1, 2));
        assertEquals(7, board1.getBoard()[1][2]);

        assertTrue(board1.calculateMove(1, 3));
        assertEquals(8, board1.getBoard()[1][3]);

        assertTrue(board1.calculateMove(1, 4));
        assertEquals(9, board1.getBoard()[1][4]);

        assertTrue(board1.calculateMove(1, 5));
        assertEquals(10, board1.getBoard()[1][5]);
    }

    @org.junit.jupiter.api.Test
    void checkIfSunk() {
        board1.getBoard()[0][0] = 9;
        board1.getBoard()[0][1] = 9;
        board1.getBoard()[0][2] = 9;
        board1.getBoard()[0][3] = 9;
        board1.getBoard()[0][4] = 9;

        board1.getBoard()[1][1] = 6;
        board1.getBoard()[1][2] = 2;

        board1.getBoard()[1][0] = 9;
        board1.getBoard()[2][0] = 9;
        board1.getBoard()[3][0] = 9;
        board1.getBoard()[4][0] = 9;
        board1.getBoard()[5][0] = 9;

        board1.getBoard()[2][1] = 7;
        board1.getBoard()[3][1] = 7;
        board1.getBoard()[4][1] = 3;

        assertTrue(board1.checkIfSunk(5, 9, 0, 2));
        assertTrue(board1.checkIfSunk(5, 9, 2, 0));
        assertFalse(board1.checkIfSunk(2, 6, 1, 1));
        assertFalse(board1.checkIfSunk(3, 7, 3, 1));
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assertTrue(board1.equals(board2));
        board1.setIndex(1, 1, 3);
        board2.setIndex(1, 1, 4);
        assertFalse(board1.equals(board2));
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assertEquals(131144545, board1.hashCode());
    }
}