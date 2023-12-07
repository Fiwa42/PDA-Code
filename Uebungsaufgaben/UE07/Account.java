public class Account {
    private String owner;
    private int balance;

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public int cashOut(int amount) {
        if(balance >= amount) {
            balance -= amount;
            return balance;
        }
        return 0;
    }

    public String getBalance() {
        return owner + " has " + balance + "$";
    }
}
