package Grossuebung01;
import java.util.Scanner;

public class Temperatur {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your Celsius temperatur: ");
        int celsius = scanner.nextInt();
        double fahrenheit = 9.0 / 5 * celsius + 32;
        System.out.println("The temperatur in fahrenheit is " + fahrenheit);

        scanner.close();
    }
}