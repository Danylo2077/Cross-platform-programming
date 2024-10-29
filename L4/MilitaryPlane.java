// Клас військового літака
public class MilitaryPlane implements Airplane {
    private String info;
    private int weaponCapacity;

    public MilitaryPlane(String info, int weaponCapacity) {
        this.info = info;
        this.weaponCapacity = weaponCapacity;
    }

    @Override
    public void performMaintenance() {
        System.out.println("Військовий літак пройшов техогляд.");
    }

    @Override
    public void repair() {
        System.out.println("Військовий літак відремонтовано.");
    }

    @Override
    public void makeFlight() {
        System.out.println("Військовий літак виконує бойову місію.");
    }

    @Override
    public void refuel() {
        System.out.println("Військовий літак заправлено.");
    }

    @Override
    public String getInfo() {
        return "Інформація про військовий літак: " + info + ", боєзапас: " + weaponCapacity;
    }

    @Override
    public void updateInfo(String newInfo) {
        info = newInfo;
        System.out.println("Інформацію про військовий літак оновлено.");
    }

    //  метод для військового літака
    public void deployWeapons() {
        System.out.println("Військовий літак використовує озброєння.");
    }
}
