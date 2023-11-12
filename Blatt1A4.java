public class Blatt1A4 {

    public static void main(String[] args) {
        System.out.println(countAdditions(7));
    }

    public static int countAdditions(int start) {
        int number = 7;
        int counter = 0;

        while (number <= 30) { // number + 6, solange number 30 nicht überschreitet
            number = number + 6;
            counter++; // counter + 1 für jeden Durchlauf der Schleife
        }

        return counter;
    }
}
