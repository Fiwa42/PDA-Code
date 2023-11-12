import java.util.Arrays;

public class Zusatzaufgabe {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] reversed = reverse(values);
        System.out.println(Arrays.toString(reversed));
    }

    public static int[] reverse(int[] values) {
        int[] result = new int[values.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = values[values.length - i - 1];
        }

        return result;
    }

    public static int addMinMax(int[] values) {

        if (values.length == 0) {
            return 0;
        }

        int min = values[0];
        int max = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
            if (values[i] > max) {
                max = values[i];
            }
        }
        return min + max;
    }
}
