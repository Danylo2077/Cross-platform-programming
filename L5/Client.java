public class Client {
    private int clientId; // Ідентифікатор клієнта
    private String name; // Ім'я клієнта

    // Конструктор класу Client
    public Client(int clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    // Повертає ID клієнта
    public int getClientId() {
        return clientId;
    }

    // Повертає ім'я клієнта
    public String getName() {
        return name;
    }

    // Перевизначений метод toString для представлення об'єкта у вигляді рядка
    @Override
    public String toString() {
        return "ID: " + clientId + ", Name: " + name;
    }
}