import java.util.Scanner;

public class Ratespiel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randomNumber = ( int )( Math . random () * 101.0);
        int counter = 0;
        
        while (true) {
            System.out.println("Zahl: ");
            int inputGuess = scanner.nextInt();

            if (randomNumber > inputGuess) {
                System.out.println("Zufallszahl ist größer!");
                counter++;
            } else if (randomNumber < inputGuess) {
                System.out.println("Zufallszahl ist kleiner!");
                counter++;
            } else if (randomNumber == inputGuess) {
                counter++;
                System.out.println("Geschafft! Zufallszahl war "+ randomNumber + " und es wurden " + counter + " Versuche gebraucht");
                break;
            }
        }
        scanner.close();
    }
}
