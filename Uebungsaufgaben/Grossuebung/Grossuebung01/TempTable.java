package Grossuebung01;
public class TempTable {
    public static void main(String[] args) {

        int startTemp = -20;

        System.out.println("Celsius" + "\t" + "|" + "\t" + "Fahrenheit");

        while (startTemp <= 30) {
            double fahrenheit = 9.0 / 5 * startTemp + 32;
            System.out.println(startTemp + "\t" + "|" + "\t" + fahrenheit);
            startTemp++;
        }
    }
}