import javax.swing.*;

public class BattleshipButton extends JButton
{
    private int row;
    private int col;
    private boolean blank;
    private boolean miss;
    private boolean hit;
    private ImageIcon blankIcon;
    private ImageIcon missIcon;
    private ImageIcon hitIcon;

    public BattleshipButton(int row, int col)
    {
        super();
        this.row = row;
        this.col = col;
        blankIcon = new ImageIcon("src/wave.png");
        missIcon = new ImageIcon("src/miss.png");
        hitIcon = new ImageIcon("src/hit.png");
        isBlank();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean getBlank() {
        return blank;
    }

    public boolean getMiss() {
        return miss;
    }

    public boolean getHit() {
        return hit;
    }

    public void isBlank() {
        blank = true;
        miss = false;
        hit = false;
        setIcon(blankIcon);
        setEnabled(true);
    }

    public void isMiss() {
        miss = true;
        blank = false;
        hit = false;
        setIcon(missIcon);
        setEnabled(false);
    }

    public void isHit() {
        hit = true;
        miss = false;
        blank = false;
        setIcon(hitIcon);
        setEnabled(false);
    }
}
