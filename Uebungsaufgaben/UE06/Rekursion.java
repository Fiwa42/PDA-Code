public class Rekursion {
    public static void main(String[] args) {
        int[] test = {2, 4, 1, 3, 7};
        stepSum(test);
        System.out.println();
        stepSumRightAlign(test);
    }

    private static void stepSum(int[] test) {
        int[] test2 = new int[test.length - 1];

        if (test.length == 1) {
            System.out.println(test[0]);
            return;
        }

        for(int i = 0; i < test2.length; i++) {
            test2[i] = test[i] + test[i + 1];

        }

        stepSum(test2);

        for(int j = 0; j < test.length; j++) {
            System.out.print(test[j] + " ");
        }

        System.out.println();
    }

    private static void stepSumRightAlign(int[] test) {
        int[] test2 = new int[test.length - 1];
        int width = 0;

        if (test.length == 1) {
            for (int m = 0; m < width; m++) {
                System.out.print(" ");
            }
            System.out.println(test[0]);
            return;
        }

        for(int i = 0; i < test2.length; i++) {
            test2[i] = test[i] + test[i + 1];

        }

        width = maxWidth(test);

        stepSumRightAlign(test2);

        for(int k = 0; k < width; k++) {
            System.out.print(" ");
        }

        for(int j = 0; j < test.length; j++) {
            System.out.print(test[j] + " ");
        }

        System.out.println();

        return;
    }

    private static int maxWidth(int[] test) {
        if (test.length == 1) {
            return 0;
        }

        int width = test.length + test.length - 1;
        return width;
    }
}
