public class Furniture {
    protected String material;
    protected String color;

    public Furniture(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Material: " + material + ", Color: " + color);
    }
}
