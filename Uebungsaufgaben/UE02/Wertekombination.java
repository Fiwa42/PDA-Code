public class Wertekombination {
    public static void main(String[] args) {
        int number = 5;
        long numberLong = 50L;
        float numberFloat = 5.6F;
        double numberDouble = 10.6;
        char numberChar = 'A';

        double sumDouble = number + numberLong + numberFloat + numberDouble + numberChar;

        int sumInt = number + (int) numberLong + (int) numberFloat + (int) numberDouble + numberChar;

        System.out.println(sumDouble + " " + sumInt);
    }
}
