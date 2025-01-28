public class Guppy extends Fish {
    private String color;

    public Guppy (String name, int lengthOfLife, int size, String color) {
        super(name, lengthOfLife, size);
        setColor(color);
        this.cost = 3.7;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\n   Имя: " + getName() + "\n" +
                "   Продолжительность жизни: " + CheckValue.getAge(getLengthOfLife()) + "\n" +
                "   Размер: " + getSize() + " (см)\n" +
                "   Цвет: " + getColor() + "\n" +
                "   Цена: " + getCost() + " р.\n";
    }
}
