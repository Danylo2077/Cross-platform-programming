public class Main {
    public static void main(String[] args) {
        Sofa sofa1 = new Sofa("Тканина", "Сірий", 3);
        Sofa sofa2 = new Sofa("Шкіра", "Чорний", 2);
        Wardrobe wardrobe1 = new Wardrobe("Дерево", "Коричневий", 5);
        Wardrobe wardrobe2 = new Wardrobe("Метал", "Сріблястий", 3);
        Wardrobe wardrobe3 = new Wardrobe("Метал", "Сріблястий", 4);

        Room room = new Room();
        room.addFurniture(sofa1);
        room.addFurniture(sofa2);
        room.addFurniture(wardrobe1);
        room.addFurniture(wardrobe2);
        room.addFurniture(wardrobe3);

        System.out.println("Кількість диванів в кімнаті: " + room.countSofas());
        System.out.println("Кількість шаф-купе в кімнаті: " + room.countWardrobes());
    }
}
