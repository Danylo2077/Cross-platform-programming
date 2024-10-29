
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів цивільного та військового літаків
        CivilianPlane civilianPlane = new CivilianPlane("Boeing 800", 416);
        MilitaryPlane militaryPlane = new MilitaryPlane("F-16 Fighting Falcon", 10);

        // Використання методів інтерфейсу і класових методів
        System.out.println(civilianPlane.getInfo());
        civilianPlane.performMaintenance();
        civilianPlane.makeFlight();
        civilianPlane.servePassengers();
        civilianPlane.updateInfo("Boeing 800 MAX");
        System.out.println(civilianPlane.getInfo());

        System.out.println("\n" + militaryPlane.getInfo());
        militaryPlane.performMaintenance();
        militaryPlane.makeFlight();
        militaryPlane.deployWeapons();
        militaryPlane.updateInfo("F-16 Advanced");
        System.out.println(militaryPlane.getInfo());
    }
}
