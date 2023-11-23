public class Methods {
    public static void main (String[] args){
        //Test Database
        int [] wholeNumbers = {-92183,1,6,9,3,90,27,2,80,91239,-12,-8213};
        double [] fraqNumbers = {5.39,17.2,2.9};
        char letter = 'i';

        //Executing Methods and printing the results
        System.out.println(min(wholeNumbers));
        System.out.println(product(fraqNumbers));
        System.out.println(java.util.Arrays.deepToString(createIdentityMatrix(4))); //Correct Result, printing doesn't create new lines for the different dimensions though
        System.out.println(letter+" is latin letter:"+isLatinLetter(letter));
    }

    //Returns the smallest number of an one dimensional array
    public static int min(int values[]){
        int minNumber = values [0];
        for(int i=1;i<values.length;i++){
            if (values [i] <= minNumber) {
                minNumber = values [i];
            }
        }
        return minNumber;
    }

    //Returns the product of an one dimensional array
    public static double product (double [] values) {
        double product = values[0];
        for (int i=1;i<values.length;i++){
            product *= values[i];
        }
        return product;
    }

    //Returns true if letter is a letter of the latin alphabet; false if not
    public static boolean isLatinLetter (char letter){
        if (letter >=65 &&  letter <= 90 || letter >= 97 && letter <= 122){
            return true;
        } else{
            return false;
        }
    }

    /* Creates a two dimensional identity matrix.
     * {1 0 - 0 0}
     * {0 1 - 0 0}
     * {- - - - -}
     * {0 0 - 1 0}
     * {0 0 - 0 1}
     */
    public static int [] [] createIdentityMatrix (int size) {
        int [] [] identityMatrix = new int [size] [size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                // The 1's have to be on the Coordinates: (1,1) , (2,2) , (3,3) , ... , (i,j) with i=j
                if (i==j){
                    identityMatrix [i] [j] = 1;
                } else {
                    // Empty spaces get filled with 0's
                    identityMatrix [i] [j] = 0;
                }
            }
        }
        return identityMatrix;
    }
}