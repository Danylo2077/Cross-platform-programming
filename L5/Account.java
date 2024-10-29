
public class Account {
    private int accountId; // Ідентифікатор рахунка
    private double balance; // Баланс рахунка

    // Конструктор класу Account
    public Account(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    // Повертає ID рахунка
    public int getAccountId() {
        return accountId;
    }

    // Повертає баланс рахунка
    public double getBalance() {
        return balance;
    }

    // Задає баланс рахунка
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Перевизначений метод toString для представлення об'єкта у вигляді рядка
    @Override
    public String toString() {
        return "Account ID: " + accountId + ", Balance: " + balance;
    }
}