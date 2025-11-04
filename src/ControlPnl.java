import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * Allows the creation of pre-designed JPanel objects with JButton controls for
 * quitting and replaying a Battleship program. Also includes methods for acting
 * on and comparing said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ControlPnl extends JPanel
{
    //This JButton is used to reset the game
    JButton playAgainBtn;

    //This JButton is used to quit the game
    JButton quitBtn;

    //This BattleshipGame allows the game instance to be passed into the ControlPnl so its methods can be used
    BattleshipGame game;

    //This constructor gives the ControlPnl a layout, establishes the JButtons, and gives them ActionListeners for functionality
    public ControlPnl(BattleshipGame game)
    {
        this.game = game;
        setLayout(new GridLayout(1, 2));
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        playAgainBtn = new JButton("Play Again");
        quitBtn = new JButton("Quit");

        add(playAgainBtn);

        playAgainBtn.addActionListener((ActionEvent ae) -> {
            //This int tracks whether the user confirmed or denied they wanted to replay
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //This algorithm determines whether to reset the program based on the user's input
            if(selection == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Starting a new game...");

                //Here, the program calls a method from the game for clearing the board
                game.clearBoard();
            } else {
                JOptionPane.showMessageDialog(null, "Your existing game will remain open.");
            }
        });

        add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> {
            //This int tracks whether the user confirmed or denied they wanted to quit the program
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit? You can press Play Again to replay.", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //This algorithm determines whether to quit the program based on the user's input
            if(selection == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Quitting the program...");
                System.exit(0);
            } else
            {
                JOptionPane.showMessageDialog(null, "The program will remain open.");
            }
        });
    }

    public JButton getPlayAgainBtn() {
        return playAgainBtn;
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }

    public BattleshipGame getGame() {
        return game;
    }
}
