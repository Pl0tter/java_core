package homework04;

public class Account {
    private double balance;

    Account(double balance) {
        this.balance = balance;
    }

    static Account create(double balance) {
        if (balance >= 0) return new Account(balance);
        else throw new IllegalArgumentException("Попытка создать счет с отрицательным начальным балансом");
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else throw new IllegalArgumentException("Попытка внести депозит с отрицательной суммой");
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < balance) balance -= amount;
        else
            throw new InsufficientFundsException("Попытка снять средства, сумма которых превышает текущий баланс",
                    amount, balance);
    }

    public double getBalance() {
        return balance;
    }
}
