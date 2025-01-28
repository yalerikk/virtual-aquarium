public class Swordtail extends Fish{
    private String tailShape;
    public Swordtail(String name, int lengthOfLife, int size, String tailShape) {
        super(name, lengthOfLife, size);
        setTailShape(tailShape);
        this.cost = 3.9;
    }

    public String getTailShape() {
        return tailShape;
    }

    public void setTailShape(String tailShape) {
        this.tailShape = tailShape;
    }

    @Override
    public String  toString() {
        return "\n   Имя: " + getName() + "\n" +
                "   Продолжительность жизни: " + CheckValue.getAge(getLengthOfLife()) + "\n" +
                "   Размер: " + getSize() + " (см)\n" +
                "   Форма хвоста: " + getTailShape() + "\n" +
                "   Цена: " + getCost() + " р.\n";
    }
}
