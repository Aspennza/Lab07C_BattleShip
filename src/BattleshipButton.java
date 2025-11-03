import javax.swing.*;
import java.awt.*;

/**
 * Allows the creation of JButtons representing a single visible index on a
 * Battleship board GUI. Stores its own row, column, and whether it is
 * a blank tile, a missed tile, or a hit tile. Also includes methods
 * for acting on and updating BattleshipButton objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class BattleshipButton extends JButton
{
    //The row location of the button
    private int row;

    //The column location of the button
    private int col;

    //A boolean representing whether the tile is blank
    private boolean blank;

    //A boolean representing whether the tile is missed
    private boolean miss;

    //A boolean representing whether the tile is hit
    private boolean hit;

    //An ImageIcon for a blank tile
    private ImageIcon blankIcon;

    //An ImageIcon for a missed tile
    private ImageIcon missIcon;

    //An ImageIcon for a hit tile
    private ImageIcon hitIcon;

    //This constructor establishes the row, column, and icons for the button and sets it to blank automatically
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

    public ImageIcon getBlankIcon() {
        return blankIcon;
    }

    public ImageIcon getMissIcon() {
        return missIcon;
    }

    public ImageIcon getHitIcon() {
        return hitIcon;
    }

    /**
     * This method sets a given JButton to blank and changes its icon to the blankIcon
     */
    public void isBlank() {
        blank = true;
        miss = false;
        hit = false;
        setIcon(blankIcon);
        setEnabled(true);
        setBackground(new Color(116, 180, 214));
    }

    /**
     * This method sets a given JButton to a miss and changes its icon to the missIcon; also disables it from being clicked
     */
    public void isMiss() {
        miss = true;
        blank = false;
        hit = false;
        setIcon(missIcon);
        setDisabledIcon(missIcon);
        setEnabled(false);
        setBackground(new Color(246, 225, 95));
    }

    /**
     * This method sets a given JButton to a hit and changes its icon to the hitIcon; also disables it from being clicked
     */
    public void isHit() {
        hit = true;
        miss = false;
        blank = false;
        setIcon(hitIcon);
        setDisabledIcon(hitIcon);
        setEnabled(false);
        setBackground(new Color(193, 20, 32));
    }
}
