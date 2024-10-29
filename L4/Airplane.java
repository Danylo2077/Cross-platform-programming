// Інтерфейс для літака
public interface Airplane {
    void performMaintenance(); // техогляд
    void repair();             // ремонт
    void makeFlight();         // здійснити рейс
    void refuel();             // заправити
    String getInfo();          // одержати інформацію про транспортний засіб
    void updateInfo(String newInfo); // змінити інформацію
}
