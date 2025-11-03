import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class BoardPnl extends JPanel
{
    BattleshipButton[][] boardGUI;
    BattleshipButtonListener listener;
    BattleshipGame game;

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
