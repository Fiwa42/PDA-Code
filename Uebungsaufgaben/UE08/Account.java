public class Account {

	private String owner;
	private double balance;

	public Account(String owner) {
		setOwner(owner);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance = getBalance() + amount;
	}

	public boolean withdraw(double amount) {
		if (getBalance() >= amount) {
			balance = getBalance() - amount;
			return true;
		} else {
			return false;
		}
	}

	public boolean transfer(double amount, Account other) {
		if(amount > balance || amount < 0) {
            return false;
        }
		
        balance -= amount;
        other.deposit(amount);

        return true;
	}
	
}