import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Furniture> furnitureList;

    public Room() {
        furnitureList = new ArrayList<>();
    }

    public void addFurniture(Furniture furniture) {
        furnitureList.add(furniture);
    }

    public int countSofas() {
        int count = 0;
        for (Furniture furniture : furnitureList) {
            if (furniture instanceof Sofa) {
                count++;
            }
        }
        return count;
    }

    public int countWardrobes() {
        int count = 0;
        for (Furniture furniture : furnitureList) {
            if (furniture instanceof Wardrobe) {
                count++;
            }
        }
        return count;
    }
}
