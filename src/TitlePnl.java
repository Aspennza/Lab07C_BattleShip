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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TitlePnl titlePnl = (TitlePnl) o;
        return Objects.equals(titleLbl, titlePnl.titleLbl) && Objects.equals(titleFont, titlePnl.titleFont);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleLbl, titleFont);
    }
}
