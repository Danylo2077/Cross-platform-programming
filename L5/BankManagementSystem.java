import java.util.*;

public class BankManagementSystem {
    private HashMap<Integer, Client> clients = new HashMap<>(); // Мапа клієнтів
    private HashMap<Integer, Account> accounts = new HashMap<>(); // Мапа рахунків
    private TreeMap<Date, Transaction> transactions = new TreeMap<>(); // Мапа транзакцій з сортуванням за датою
    private PriorityQueue<Transaction> operationQueue = new PriorityQueue<>(); // Черга операцій
    private Scanner scanner = new Scanner(System.in); // Об'єкт для зчитування введення з консолі

    public void start() {
        while (true) {
            System.out.println("\n--- Банківська система ---");
            System.out.println("1. Додати клієнта");
            System.out.println("2. Переглянути клієнтів");
            System.out.println("3. Додати рахунок");
            System.out.println("4. Переглянути рахунки");
            System.out.println("5. Додати транзакцію");
            System.out.println("6. Переглянути транзакції");
            System.out.println("7. Виконати операції");
            System.out.println("0. Вийти");
            System.out.print("Оберіть опцію: ");

            int choice = getIntInput("");
            scanner.nextLine(); // очищення буфера

            switch (choice) {
                case 1 -> addClient();
                case 2 -> viewClients();
                case 3 -> addAccount();
                case 4 -> viewAccounts();
                case 5 -> addTransaction();
                case 6 -> viewTransactions();
                case 7 -> processOperations();
                case 0 -> System.exit(0);
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    // Додає нового клієнта в систему
    private void addClient() {
        int clientId = getIntInput("Введіть ID клієнта: ");
        String name = getNameInput("Введіть ім'я клієнта: ");

        clients.put(clientId, new Client(clientId, name));
        System.out.println("Клієнта додано.");
    }

    // Виводить усіх клієнтів
    private void viewClients() {
        for (Client client : clients.values()) {
            System.out.println(client);
        }
    }

    // Додає новий рахунок
    private void addAccount() {
        int accountId = getIntInput("Введіть ID рахунка: ");
        double balance = getDoubleInput("Введіть баланс рахунка: ");

        accounts.put(accountId, new Account(accountId, balance));
        System.out.println("Рахунок додано.");
    }

    // Виводить усі рахунки
    private void viewAccounts() {
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }

    // Додає нову транзакцію
    private void addTransaction() {
        int transactionId = getIntInput("Введіть ID транзакції: ");
        int accountId = getIntInput("Введіть ID рахунка: ");
        double amount = getDoubleInput("Введіть суму транзакції: ");
        Date date = new Date();

        Transaction transaction = new Transaction(transactionId, accountId, amount, date);
        transactions.put(date, transaction);
        operationQueue.add(transaction);

        System.out.println("Транзакцію додано.");
    }

    // Виводить усі транзакції
    private void viewTransactions() {
        for (Map.Entry<Date, Transaction> entry : transactions.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Виконує операції з черги транзакцій
    private void processOperations() {
        while (!operationQueue.isEmpty()) {
            Transaction transaction = operationQueue.poll();
            System.out.println("Виконується операція: " + transaction);
            Account account = accounts.get(transaction.getAccountId());
            if (account != null) {
                account.setBalance(account.getBalance() + transaction.getAmount());
            } else {
                System.out.println("Помилка: рахунок не знайдено.");
            }
        }
    }

    // Метод для запиту цілого числа з перевіркою
    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // очищення буфера після введення числа
                return value;
            } else {
                System.out.println("Помилка: введіть ціле число.");
                scanner.next(); // очищення некоректного введення
            }
        }
    }

    // Метод для запиту числа з плаваючою комою з перевіркою
    private double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // очищення буфера після введення числа
                return value;
            } else {
                System.out.println("Помилка: введіть коректну числову суму.");
                scanner.next(); // очищення некоректного введення
            }
        }
    }

    // Метод для запиту імені з перевіркою
    private String getNameInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            // Перевірка, щоб ім'я містило лише літери та пробіли
            if (!input.isEmpty() && input.matches("[a-zA-Zа-яА-Я\\s]+")) {
                return input;
            } else {
                System.out.println("Помилка: ім'я повинно містити лише літери.");
            }
        }
    }
}
