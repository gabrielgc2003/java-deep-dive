package example.br.models;

public class Client implements Runnable{
    private final BankAccount account;
    private final double amount;

    public Client(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount); // or account.depositWithLock(amount);
        account.withdraw(amount / 2); // or account.withdrawWithLock(amount / 2);
    }
}
