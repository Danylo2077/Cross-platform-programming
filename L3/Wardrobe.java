public class Wardrobe extends Furniture {
    private int shelves;

    public Wardrobe(String material, String color, int shelves) {
        super(material, color);
        this.shelves = shelves;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Кількість полиць: " + shelves);
    }
}
