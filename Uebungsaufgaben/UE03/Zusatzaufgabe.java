public class Zusatzaufgabe {
    public static void main(String[] args) {
        int[] a = {3, 2, 3, 1, 4, 3};
        countingsort(a);
        System.out.println(a);

    }

    public static void countingsort (int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] h = new int[max + 1];
            
        for (int i = 0; i < a.length; i++) {
            h[a[i]]++;
        }

        int index = 0;
        for(int i = 0; i < h.length; i++) {
            for(int j = 0; j < h[i]; j++) {
                a[index++] = i;
            }
        }
    }
}
