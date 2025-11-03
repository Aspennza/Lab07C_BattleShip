import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TitlePnl extends JPanel
{
    JLabel titleLbl;
    Font titleFont;

    public TitlePnl()
    {
        titleLbl = new JLabel("Battleship");
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
