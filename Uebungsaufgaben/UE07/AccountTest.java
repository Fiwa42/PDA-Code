public class AccountTest {
    public static void main(String[] args) {
        Account donald = new Account("Donald Duck", 0);
        Account dagobert = new Account("Dagobert Duck", 0);

        System.out.println("Donald deposits " + donald.deposit(10) + "$");
        System.out.println("Dagobert deposits " + dagobert.deposit(1000000) + "$");
        System.out.println("Donald cashes " + donald.cashOut(5) + "$ out");
        System.out.println("Dagobert cashes " + dagobert.cashOut(50000) + "$ out");
        System.out.println("Donald deposits " + donald.deposit(4000) + "$");
        System.out.println("Dagobert deposits " + dagobert.deposit(50123) + "$");
        System.out.println(donald.getBalance());
        System.out.println(dagobert.getBalance());
    }
}
