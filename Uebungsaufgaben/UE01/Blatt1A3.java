public class Blatt1A3 {

  public static void main(String[] args) {
        int a = 2;
        int b = 4;
             // calculate a to the power of b (a^b)
        int result = 1;
        int i = 0;
        while (i < b) {
            result = result * a;
            i++;
        }
            // output result of 2^4
        System.out.println(result);
    }
}