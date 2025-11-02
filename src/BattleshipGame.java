import javax.swing.*;
import java.awt.*;

//Return to writing calculateMove logic for BattleshipBoardd!!!
//Come back to working on the BattleshipGame and BattleshipBoard classes!!!


public class BattleshipGame
{
    private static final int TURNS_TO_SINK = 2;
    private JFrame frame;
    private TitlePnl titlePnl;
    private BoardPnl boardPnl;
    private StatusPnl statusPnl;
    private ControlPnl controlPnl;
    private BattleshipBoard board;
    private ShipPlacer placer;
    private boolean playing;
    Ship ship1 = new Ship(5);
    Ship ship2 = new Ship(4);
    Ship ship3 = new Ship(3);
    Ship ship4 = new Ship(3);
    Ship ship5 = new Ship(2);

    public void startGame() {
        placer.placeShip(ship1);
        placer.placeShip(ship2);
        placer.placeShip(ship3);
        placer.placeShip(ship4);
        placer.placeShip(ship5);
    }

    public void buttonAction(int row, int col)
    {
        boolean isHit = false;
        if(playing) {
            if(board.isValidMove(row, col))
            {
                 isHit = board.calculateMove(row, col);
                 if(isHit) {
                     boardPnl.getBoardGUI()[row][col].isHit();
                     if (board.checkIfSunk(2, row, col))
                     {
                         JOptionPane.showMessageDialog(frame, "Congrats! You sunk the opponent's 2-tile ship!");
                     }

                     if (board.checkIfSunk(3, row, col)) {
                         JOptionPane.showMessageDialog(frame, "Congrats! You sunk one of the opponent's 3-tile ships!");
                     }

                     if (board.checkIfSunk(4, row, col)) {
                         JOptionPane.showMessageDialog(frame, "Congrats! You sunk the opponent's 4-tile ship!");
                     }
                     if (board.checkIfSunk(5, row, col)) {
                         JOptionPane.showMessageDialog(frame, "Congrats! You sunk the opponent's 5-tile ship!");
                     }

                 }else {
                     boardPnl.getBoardGUI()[row][col].isMiss();
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

    public void generateFrame() {
        frame = new JFrame();

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

        mainPnl.setLayout(new GridLayout(4, 1));
        frame.add(mainPnl);

        titlePnl = new TitlePnl();
        mainPnl.add(titlePnl);

        boardPnl = new BoardPnl(this);
        mainPnl.add(boardPnl);

        statusPnl = new StatusPnl();
        mainPnl.add(statusPnl);

        controlPnl = new ControlPnl(this);
        mainPnl.add(controlPnl);

        frame.setSize(screenWidth * 3/4, screenHeight * 3/4);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Battleship");
        frame.setVisible(true);
    }
}
