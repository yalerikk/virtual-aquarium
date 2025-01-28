public class Neon extends Fish {
    private String brightness;
    public Neon(String name, int lengthOfLife, int size, String brightness) {
        super(name, lengthOfLife, size);
        setBrightness(brightness);
        this.cost = 2.7;
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    @Override
    public String  toString() {
        return "\n   Имя: " + getName() + "\n" +
                "   Продолжительность жизни: " + CheckValue.getAge(getLengthOfLife()) + "\n" +
                "   Размер: " + getSize() + " (см)\n" +
                "   Яркость: " + getBrightness() + "\n" +
                "   Цена: " + getCost() + " р.\n";
    }
}
