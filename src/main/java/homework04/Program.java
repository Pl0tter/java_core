package homework04;

import java.util.Random;

/**
 * 1. Создать программу управления банковским счетом (Account).
 * <p>
 * Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств.
 * При этом она должна обрабатывать следующие исключительные ситуации:
 * <p>
 * Попытка создать счет с отрицательным начальным балансом должна вызывать
 * исключение IllegalArgumentException с соответствующим сообщением.
 * Попытка внести депозит с отрицательной суммой должна вызывать
 * исключение IllegalArgumentException с соответствующим сообщением.
 * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать
 * исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 * выводя соответствующие сообщения об ошибках.
 * <p>
 * 2*. Создать несколько типов счетов, унаследованных от Account, например: CreditAccount, DebitAccount.
 * Создать класс (Transaction), позволяющий проводить транзакции между счетами (переводить сумму с одного счета на другой)
 * <p>
 * Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги с одного счета на другой.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.
 */
public class Program {
    private static Random random = new Random();

    public static void main(String[] args) {
        try {
            Account account;
            if (random.nextInt(3) == 0) {
                account = Account.create(-200);
            } else {
                account = Account.create(200);
            }
            if (random.nextInt(3) == 0) {
                account.deposit(-200);
            } else {
                account.deposit(200);
            }
            if (random.nextInt(3) == 0) {
                account.withdraw(100000);
            } else {
                account.withdraw(1000);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.printf("Ошибка: %s \nБаланс: %.2f. Запрашиваемая сумма: %.2f\n",
                    e.getMessage(), e.getBalance(), e.getAmount());
        }

        System.out.println("-------");

        try {
            Transaction transaction = new Transaction();
            if (random.nextInt(2) == 0) {
                transaction.transact(new CreditAccount(0), new DebitAccount(10000), 5000);
                System.out.println("Перевод выполнен");
            } else {
                transaction.transact(new CreditAccount(0), new DebitAccount(100), 5000);
            }
        } catch (InsufficientFundsException e) {
            System.out.printf("Ошибка: %s \nБаланс: %.2f. Запрашиваемая сумма: %.2f\n",
                    e.getMessage(), e.getBalance(), e.getAmount());
        }
    }
}
