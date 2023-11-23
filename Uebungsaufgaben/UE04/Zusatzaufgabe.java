import java.util.Stack;

public class Zusatzaufgabe {

    public static void multipopIterative(Stack s, int k) {
        while(!s.isEmpty() && k > 0) {
            s.pop();
            k = k - 1;
        }
    }

    public static void multipopRecursive(Stack s, int k) {
        if(k <= 0 || s.isEmpty()) {
            return;
        }

        s.pop();
        multipopRecursive(s, k - 1);
    }

    public static boolean isReverse(char[] a, char[] b) {
       if(a.length != b.length) {
            return false;
       }

       int startIndex = 0;
       int endIndex = a.length - 1;

       while(startIndex <= endIndex) {
        if(a[startIndex] != b[endIndex]) {
            return false;
        }

        startIndex++;
        endIndex--;
       }
       return true;
    }


}
