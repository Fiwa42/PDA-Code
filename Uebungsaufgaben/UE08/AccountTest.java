public class AccountTest {
    public static void main(String[] args) {
        Account donald = new Account("Donald Duck");
        Account dagobert = new Account("Dagobert Duck");

        donald.deposit(100);
        donald.transfer(50,dagobert);

        System.out.println(dagobert.getBalance()); //50
        System.out.println(donald.getBalance()); //50

        donald.deposit(30);
        dagobert.transfer(-20, donald); //He can't steal his money by transfering a negative amount

        System.out.println(dagobert.getBalance()); //50
        System.out.println(donald.getBalance()); //80
    }
}

