import javax.swing.*;

//Come back to working on the BattleshipGame and BattleshipBoard classes!!!


public class BattleshipGame
{
    private JFrame frame;
    private TitlePnl titlePnl;
    private BoardPnl boardPnl;
    private StatusPnl statusPnl;
    private ControlPnl controlPnl;
    private BattleshipBoard board;
    private boolean playing;

    public void buttonAction(int row, int col)
    {
        if(playing) {
            if(boardPnl.i
        } else
        {
            JOptionPane.showMessageDialog(frame, "The game is over. Select Play Again to replay!");
        }

    }
}
