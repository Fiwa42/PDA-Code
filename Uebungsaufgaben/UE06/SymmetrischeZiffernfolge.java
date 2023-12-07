public class SymmetrischeZiffernfolge{
    public static void main (String [] args){ 
        System.out.println(symmetricDigitSequence (9));
        System.out.println(symmetricDigitSequenceRec(6));
    }

    //Aufgabe 2a)
    public static String symmetricDigitSequence(int max){
        //The result will always have a zero in the center
        String result = "0";

        //Iterate through i and add the digits in front of and behind the result
        for (int i=1; i <= max ; i++){
            result = i + result + i;
        }
        
        return result;
    }

    //Aufgabe 2b)
    public static String symmetricDigitSequenceRec(int max){
        //Termination condition
        if (max == 1) {
            return max +"0"+ max;
        }

        return max + symmetricDigitSequenceRec(max-1) + max;
    }
}