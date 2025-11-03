import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StatusPnl extends JPanel
{
    JLabel missLbl;
    JLabel strikeLbl;
    JLabel totalMissLbl;
    JLabel totalHitLbl;
    JTextField missTF;
    JTextField strikeTF;
    JTextField totalMissTF;
    JTextField totalHitTF;

    public StatusPnl()
    {
        setLayout(new GridLayout(2, 4));

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
