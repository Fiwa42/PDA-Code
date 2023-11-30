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

    static int maxLength = 0;

	private static void stepSumRightAlign( int[] test ) {
		if ( test.length == 0 ){
            return;
        }

		String string = "" + test[0];												
		if (maxLength < string.length()) {
            maxLength = string.length();      
        }

		if (test.length > 1 ) {
			int[] test2 = new int[ test.length - 1 ];
            
			for (int i = 1; i < test.length; i++) {
				test2[i - 1] = test[i - 1] + test[i];
				string = string + " " + test[i];
			}

			if (maxLength < string.length()) {
                maxLength = string.length();
            }	
			stepSumRightAlign(test2);
		}
		System.out.println(String.format( "%" + maxLength + "s", string));
	}
}