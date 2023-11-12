import java.util.Scanner;

public class Kostenberechnung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Anzahl der Downloads >= 0: ");
        int downloads = scanner.nextInt();
        float price = 0;

        for (int i = 0; i <= downloads; i++) {
            if (i > 5 && i < 36) {
                price += 0.2;
            } else if (i > 35) {
                price += 0.15;
            }
        }

        System.out.println("Kosten: " + price );

        scanner.close();

    }
}
