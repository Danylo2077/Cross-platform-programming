// Клас цивільного літака
public class CivilianPlane implements Airplane {
    private String info;
    private int passengerCapacity;

    public CivilianPlane(String info, int passengerCapacity) {
        this.info = info;
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void performMaintenance() {
        System.out.println("Цивільний літак пройшов техогляд.");
    }

    @Override
    public void repair() {
        System.out.println("Цивільний літак відремонтовано.");
    }

    @Override
    public void makeFlight() {
        System.out.println("Цивільний літак виконує комерційний рейс.");
    }

    @Override
    public void refuel() {
        System.out.println("Цивільний літак заправлено.");
    }

    @Override
    public String getInfo() {
        return "Інформація про цивільний літак: " + info + ", пасажиромісткість: " + passengerCapacity;
    }

    @Override
    public void updateInfo(String newInfo) {
        info = newInfo;
        System.out.println("Інформацію про цивільний літак оновлено.");
    }

    // метод для цивільного літака
    public void servePassengers() {
        System.out.println("Цивільний літак обслуговує пасажирів.");
    }
}
