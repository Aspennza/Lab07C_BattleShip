import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ControlPnl extends JPanel
{
    JButton playAgainBtn;
    JButton quitBtn;
    BattleshipGame game;

    public ControlPnl(BattleshipGame game)
    {
        this.game = game;
        setLayout(new GridLayout(1, 2));

        playAgainBtn = new JButton("Play Again");
        quitBtn = new JButton("Quit");

        add(playAgainBtn);

        playAgainBtn.addActionListener((ActionEvent ae) -> {
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(selection == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Starting a new game...");
                game.clearBoard();
            } else {
                JOptionPane.showMessageDialog(null, "Your existing game will remain open.");
            }
        });

        add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> {
            //This int tracks whether the user confirmed or denied they wanted to quit the program
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

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
