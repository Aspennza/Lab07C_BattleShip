import javax.swing.*;
import java.awt.*;
import java.util.Objects;

//junit tests!
//javadoc
//crc cards
//uml

public class BattleshipGame
{
    private JFrame frame;
    private TitlePnl titlePnl;
    private BoardPnl boardPnl;
    private StatusPnl statusPnl;
    private ControlPnl controlPnl;
    private BattleshipBoard board;
    private ShipPlacer placer;
    private boolean playing;
    private int misses;
    private int totalHits;
    private int strikes;
    private int totalMisses;
    private Ship ship1 = new Ship(5, 5);
    private Ship ship2 = new Ship(4, 4);
    private Ship ship3 = new Ship(3, 3);
    private Ship ship4 = new Ship(3, 3.1);
    private Ship ship5 = new Ship(2, 2);
    private boolean ship1Sunk = false;
    private boolean ship2Sunk = false;
    private boolean ship3Sunk = false;
    private boolean ship4Sunk = false;
    private boolean ship5Sunk = false;

    public void startGame() {
        board = new BattleshipBoard();
        placer = new ShipPlacer(board);
        generateFrame();
        playing = true;
        placer.placeShip(ship1);
        placer.placeShip(ship2);
        placer.placeShip(ship3);
        placer.placeShip(ship4);
        placer.placeShip(ship5);
        JOptionPane.showMessageDialog(frame, "Welcome to Battleship! In this game, you click on empty tiles (represented by blue wave icons) to try to sink your opponent's ships.\nIf you miss a ship, a yellow splash icon appears. If you hit it, a red explosion icon appears. If you miss 5 times in a row, you get a strike, \nand if you get three strikes, the game is over. If you hit all 5 of your enemy's ships before getting three strikes, you win!");
    }

    public void buttonAction(int row, int col)
    {
        boolean isHit = false;

        if(playing) {
            if(board.isValidMove(row, col))
            {
                 isHit = board.calculateMove(row, col);
                 if(isHit) {
                     totalHits++;
                     misses = 0;
                     statusPnl.getTotalHitTF().setText("" + totalHits);
                     statusPnl.getMissTF().setText("" + misses);
                     boardPnl.getBoardGUI()[row][col].isHit();

                     checkShipsSunk(row, col);

                     checkWin();
                 }else {
                     boardPnl.getBoardGUI()[row][col].isMiss();
                     misses++;
                     totalMisses++;
                     statusPnl.getMissTF().setText("" + misses);
                     statusPnl.getTotalMissTF().setText("" + totalMisses);

                     if(misses == 5) {
                         strikes++;
                         misses = 0;

                         statusPnl.getStrikeTF().setText("" + strikes);
                         statusPnl.getMissTF().setText("" + misses);
                     }

                     checkLose();
                 }
            } else
            {
                JOptionPane.showMessageDialog(frame, "This space is already occupied. Please select a different space.");
            }
        } else
        {
            JOptionPane.showMessageDialog(frame, "The game is over. Select Play Again to replay!");
        }
    }

    public void checkShipsSunk(int row, int col) {
        if (board.checkIfSunk(2, 6, row, col))
        {
            JOptionPane.showMessageDialog(frame, "Congrats! You sunk the opponent's 2-tile ship!");
            ship5Sunk = true;
        }

        if (board.checkIfSunk(3, 7, row, col)) {
            JOptionPane.showMessageDialog(frame, "Congrats! You sunk one of the opponent's 3-tile ships!");
            ship3Sunk = true;
        }

        if(board.checkIfSunk(3, 10, row, col)) {
            JOptionPane.showMessageDialog(frame, "Congrats! You sunk one of the opponent's 3-tile ships!");
            ship4Sunk = true;
        }

        if (board.checkIfSunk(4, 8, row, col)) {
            JOptionPane.showMessageDialog(frame, "Congrats! You sunk the opponent's 4-tile ship!");
            ship2Sunk = true;
        }
        if (board.checkIfSunk(5, 9, row, col)) {
            JOptionPane.showMessageDialog(frame, "Congrats! You sunk the opponent's 5-tile ship!");
            ship1Sunk = true;
        }
    }

    public void checkWin() {
        if(ship1Sunk && ship2Sunk && ship3Sunk && ship4Sunk && ship5Sunk)
        {
            playing = false;
            JOptionPane.showMessageDialog(frame, "Congratulations! You sunk all of the opponent's ships! You win! Click Play Again to replay.");
        }
    }

    public void checkLose() {
        if(strikes == 3) {
            playing = false;
            JOptionPane.showMessageDialog(frame, "Game over! You reached three strikes before sinking the opponent's ships. Press Play Again to replay!");
        }
    }

    public void generateFrame() {
        frame = new JFrame();

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.gridheight = 1;
        gbc1.fill = GridBagConstraints.BOTH;
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 3;
        gbc2.fill = GridBagConstraints.BOTH;
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 4;
        gbc3.gridwidth = 1;
        gbc3.gridheight = 1;
        gbc3.fill = GridBagConstraints.BOTH;
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 5;
        gbc4.gridwidth = 1;
        gbc4.gridheight = 1;
        gbc4.fill = GridBagConstraints.BOTH;

        //A JPanel that contains all other JPanels in the GUI
        JPanel mainPnl = new JPanel();

        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
        int screenWidth = screenSize.width;

        mainPnl.setLayout(new GridBagLayout());
        frame.add(mainPnl);

        titlePnl = new TitlePnl();
        mainPnl.add(titlePnl, gbc1);

        boardPnl = new BoardPnl(this);
        mainPnl.add(boardPnl, gbc2);

        statusPnl = new StatusPnl();
        mainPnl.add(statusPnl, gbc3);

        controlPnl = new ControlPnl(this);
        mainPnl.add(controlPnl, gbc4);

        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Battleship");
        frame.setVisible(true);
    }

    public void clearBoard() {
        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                boardPnl.getBoardGUI()[row][col].isBlank();
            }
        }

        board.clearBoard();
        playing = true;
        placer.placeShip(ship1);
        placer.placeShip(ship2);
        placer.placeShip(ship3);
        placer.placeShip(ship4);
        placer.placeShip(ship5);
        misses = 0;
        strikes = 0;
        totalMisses = 0;
        totalHits = 0;
        statusPnl.getMissTF().setText("" + 0);
        statusPnl.getStrikeTF().setText("" + 0);
        statusPnl.getTotalMissTF().setText("" + 0);
        statusPnl.getTotalHitTF().setText("" + 0);
        ship1Sunk = ship2Sunk = ship3Sunk = ship4Sunk = ship5Sunk = false;
    }

    public JFrame getFrame() {
        return frame;
    }

    public TitlePnl getTitlePnl() {
        return titlePnl;
    }

    public BoardPnl getBoardPnl() {
        return boardPnl;
    }

    public StatusPnl getStatusPnl() {
        return statusPnl;
    }

    public ControlPnl getControlPnl() {
        return controlPnl;
    }

    public BattleshipBoard getBoard() {
        return board;
    }

    public ShipPlacer getPlacer() {
        return placer;
    }

    public boolean isPlaying() {
        return playing;
    }

    public int getMisses() {
        return misses;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getTotalMisses() {
        return totalMisses;
    }

    public Ship getShip1() {
        return ship1;
    }

    public Ship getShip2() {
        return ship2;
    }

    public Ship getShip3() {
        return ship3;
    }

    public Ship getShip4() {
        return ship4;
    }

    public Ship getShip5() {
        return ship5;
    }

    public boolean isShip1Sunk() {
        return ship1Sunk;
    }

    public boolean isShip2Sunk() {
        return ship2Sunk;
    }

    public boolean isShip3Sunk() {
        return ship3Sunk;
    }

    public boolean isShip4Sunk() {
        return ship4Sunk;
    }

    public boolean isShip5Sunk() {
        return ship5Sunk;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BattleshipGame that = (BattleshipGame) o;
        return playing == that.playing && misses == that.misses && totalHits == that.totalHits && strikes == that.strikes && totalMisses == that.totalMisses && ship1Sunk == that.ship1Sunk && ship2Sunk == that.ship2Sunk && ship3Sunk == that.ship3Sunk && ship4Sunk == that.ship4Sunk && ship5Sunk == that.ship5Sunk && Objects.equals(board, that.board) && Objects.equals(placer, that.placer) && Objects.equals(ship1, that.ship1) && Objects.equals(ship2, that.ship2) && Objects.equals(ship3, that.ship3) && Objects.equals(ship4, that.ship4) && Objects.equals(ship5, that.ship5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, placer, playing, misses, totalHits, strikes, totalMisses, ship1, ship2, ship3, ship4, ship5, ship1Sunk, ship2Sunk, ship3Sunk, ship4Sunk, ship5Sunk);
    }
}
