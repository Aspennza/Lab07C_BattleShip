import javax.swing.*;

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
    private boolean playing;
    Ship ship1 = new Ship(5);
    Ship ship2 = new Ship(4);
    Ship ship3 = new Ship(3);
    Ship ship4 = new Ship(3);
    Ship ship5 = new Ship(2);

    public void buttonAction(int row, int col)
    {
        if(playing) {
            if(board.isValidMove(row, col))
            {
                board.setIndex(row, col, );
            } else
            {
                JOptionPane.showMessageDialog(frame, "This space is already occupied. Please select a different space.");
            }
        } else
        {
            JOptionPane.showMessageDialog(frame, "The game is over. Select Play Again to replay!");
        }

    }
}
