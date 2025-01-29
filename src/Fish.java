import java.io.Serial;
import java.io.Serializable;

public abstract class Fish implements Comparable<Fish>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Уникальный идентификатор версии сериализации
    private String name;
    private int lengthOfLife;
    private int size;
    protected double cost;

    public Fish(String name, int lengthOfLife, int size) {
        setName(name);
        setLengthOfLife(lengthOfLife);
        setSize(size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLengthOfLife() {
        return lengthOfLife;
    }

    public void setLengthOfLife(int lengthOfLife) {
        this.lengthOfLife = lengthOfLife;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getCost() {
        return cost;
    }
    @Override
    public int compareTo(Fish o) {
        return this.getLengthOfLife() - o.getLengthOfLife();
    }
}
