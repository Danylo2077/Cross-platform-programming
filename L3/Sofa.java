public class Sofa extends Furniture {
    private int seats;

    public Sofa(String material, String color, int seats) {
        super(material, color);
        this.seats = seats;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Кількість місць: " + seats);
    }
}
