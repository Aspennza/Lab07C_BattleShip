import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

/**
 * Allows the creation of JPanels visually representing the board of a Battleship program.
 * Stores BattleshipButtons, an ActionListener for the buttons, and an instance of
 * BattleshipGame. Also includes methods for acting on BoardPnl objects.
 */
public class BoardPnl extends JPanel
{
    //This BattleshipButton array stores the visual representation of the battleship board
    BattleshipButton[][] boardGUI;

    //This BattleshipButtonListener defines what actions to take when a button on the board is pressed
    BattleshipButtonListener listener;

    //This BattleshipGame stores the game instance that will be passed into the BoardPnl
    BattleshipGame game;

    //This constructor sets the layout of BoardPnl and establishes the board and the listener
    public BoardPnl(BattleshipGame game)
    {
        this.game = game;
        setLayout(new GridLayout(10, 10));
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        boardGUI = new BattleshipButton[10][10];

        listener = new BattleshipButtonListener();

        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                boardGUI[row][col] = new BattleshipButton(row, col);
                boardGUI[row][col].addActionListener(listener);
                add(boardGUI[row][col]);
            }
        }
    }

    public BattleshipButton[][] getBoardGUI() {
        return boardGUI;
    }

    public BattleshipGame getGame() {
        return game;
    }

    /**
     * This class creates ActionListener objects that pass data from BattleshipButtons to the game instance.
     * @author Zoe Aspenns aspennza@mail.uc.edu
     */
    private class BattleshipButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() instanceof BattleshipButton selectedButton)
            {
                game.buttonAction(selectedButton.getRow(), selectedButton.getCol());
            }
        }
    }
}
