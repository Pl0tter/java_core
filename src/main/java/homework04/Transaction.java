package homework04;

public class Transaction {
    public void transact(CreditAccount credit, DebitAccount debit, double amount) throws InsufficientFundsException {
        debit.withdraw(amount);
        credit.deposit(amount);
    }
}
