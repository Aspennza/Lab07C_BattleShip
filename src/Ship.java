import java.util.Objects;

public class Ship
{
    private int length;
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
