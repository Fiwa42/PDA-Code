public class BedeutsameZahl {
    public static void main (String [] args){
        System.out.println(stepBack(218));
    }

    public static int stepBack (int number) {
        //Termination condition
        if (number == 4){
            return number;
        }

        //Case 1: Number ends with the digit '4'
        if (number % 10 == 4){
            System.out.println(number);
            return stepBack(number / 10);
        }

        //Case 2: Number ends with the digit '0'
        if (number % 10 == 0){
            System.out.println(number);
            return stepBack(number / 10);
        } 

        //Case 3: Number is even
        else {
            System.out.println(number);
            return stepBack(number * 2);
        }
    }
}
