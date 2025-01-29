public class Gourami extends Fish {
    private String species; // вид гурами

    public Gourami(String name, int lengthOfLife, int size, String species) {
        super(name, lengthOfLife, size);
        setSpecies(species);
        this.cost = 2.9;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String  toString() {
        return "\n   Имя: " + CheckValue.capitalizeFirstLetter(getName()) + "\n" +
                "   Вид: Гурами\n" +
                "   Продолжительность жизни: " + CheckValue.getAge(getLengthOfLife()) + "\n" +
                "   Размер: " + getSize() + " (см)\n" +
                "   Вид: " + CheckValue.capitalizeFirstLetter(getSpecies()) + "\n" +
                "   Цена: " + getCost() + " р.\n";
    }
}