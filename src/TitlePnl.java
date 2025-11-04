import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Objects;

/**
 * Allows the creation of pre-designed JPanel objects for the title panel of a Battleship program.
 * Contains a JLabel and a Font, as well as methods for acting on TitlePnl objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class TitlePnl extends JPanel
{
    //This JLabel serves as the title for the title pnl
    JLabel titleLbl;

    //This Font serves as the font of the titleLbl
    Font titleFont;

    //This constructor establishes the titleLbl and titleFont and adds them to the panel
    public TitlePnl()
    {
        titleLbl = new JLabel("Battleship");
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        titleFont = new Font("Serif", Font.BOLD, 36);
        titleLbl.setFont(titleFont);
        add(titleLbl);

    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    public Font getTitleFont() {
        return titleFont;
    }
}
