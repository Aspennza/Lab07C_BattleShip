import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Objects;

/**
 * Allows the creation of pre-designed JPanel objects for the status panel of a Battleship program.
 * Contains a number of JLabels and text fields for outputting misses, strikes, hits, etc. Also contains
 * methods for acting on StatusPnl objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class StatusPnl extends JPanel
{
    //A JLabel for the misses field
    JLabel missLbl;

    //A JLabel for the strikes field
    JLabel strikeLbl;

    //A JLabel for the total misses field
    JLabel totalMissLbl;

    //A JLabel for the total hits field
    JLabel totalHitLbl;

    //A JTextField for outputting the number of misses
    JTextField missTF;

    //A JTextField for outputting the number of strikes
    JTextField strikeTF;

    //A JTextField for outputting the number of total misses
    JTextField totalMissTF;

    //A JTextField for outputting the total number of hits
    JTextField totalHitTF;

    //This constructor establishes the layout, JLabels, and JTextFields in the StatusPnl
    public StatusPnl()
    {
        setLayout(new GridLayout(2, 4));
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        missLbl = new JLabel("Misses:");
        strikeLbl = new JLabel("Strikes:");
        totalMissLbl = new JLabel("Total Misses:");
        totalHitLbl = new JLabel("Total Hits:");
        missTF = new JTextField(15);
        missTF.setText("" + 0);
        strikeTF = new JTextField(15);
        strikeTF.setText("" + 0);
        totalMissTF = new JTextField(15);
        totalMissTF.setText("" + 0);
        totalHitTF = new JTextField(15);
        totalHitTF.setText("" + 0);

        add(missLbl);
        add(missTF);
        add(strikeLbl);
        add(strikeTF);
        add(totalMissLbl);
        add(totalMissTF);
        add(totalHitLbl);
        add(totalHitTF);
    }

    public JLabel getMissLbl() {
        return missLbl;
    }

    public JLabel getStrikeLbl() {
        return strikeLbl;
    }

    public JLabel getTotalMissLbl() {
        return totalMissLbl;
    }

    public JLabel getTotalHitLbl() {
        return totalHitLbl;
    }

    public JTextField getMissTF() {
        return missTF;
    }

    public JTextField getStrikeTF() {
        return strikeTF;
    }

    public JTextField getTotalMissTF() {
        return totalMissTF;
    }

    public JTextField getTotalHitTF() {
        return totalHitTF;
    }
}
