import java.util.Objects;

/**
 * Allows the creation of ship objects for storing a battleship's
 * length and unique ID. Also includes functions for acting on
 * and comparing ships.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class Ship
{
    //This int stores the length of the ship
    private int length;

    //This double stores the ship's unique ID
    private double ID;

    public Ship(int length, double ID)
    {
        this.length = length;
        this.ID = ID;
    }

    public int getLength()
    {
        return length;
    }

    public double getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return length == ship.length && Double.compare(ID, ship.ID) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, ID);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "length=" + length +
                ", ID=" + ID +
                '}';
    }
}
