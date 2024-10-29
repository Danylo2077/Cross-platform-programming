import java.util.Date;
public class Transaction implements Comparable<Transaction> {
    private int transactionId; // Ідентифікатор транзакції
    private int accountId; // ID рахунка, до якого належить транзакція
    private double amount; // Сума транзакції
    private Date date; // Дата транзакції

    // Конструктор класу Transaction
    public Transaction(int transactionId, int accountId, double amount, Date date) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
    }

    // Повертає ID транзакції
    public int getTransactionId() {
        return transactionId;
    }

    // Повертає ID рахунка
    public int getAccountId() {
        return accountId;
    }

    // Повертає суму транзакції
    public double getAmount() {
        return amount;
    }

    // Повертає дату транзакції
    public Date getDate() {
        return date;
    }

    // Метод для порівняння транзакцій за датою
    @Override
    public int compareTo(Transaction other) {
        return this.date.compareTo(other.date);
    }

    // Перевизначений метод toString для представлення об'єкта у вигляді рядка
    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Account ID: " + accountId + ", Amount: " + amount + ", Date: " + date;
    }
}