/*  a) Nummerierte Liste von Aktionen:
 *      1. Test-Matrizen initialisieren und Methodenkopf schreiben
 *      2. Rumpf der Methode:
 *          1. Überprüfen ob die Matrizen miteinander multiplizierbar sind, d.h. matrixA [i] [j] und matrixB [j] [k]
 *          2. Ausgabe-Matrix initialisieren
 *          3. Matrizen 1 und 2 multiplizieren und jeweils die Ergebnisse in die Ausgabe-Matrix schreiben
 *              1. Anzahl der notwendigen Multiplikationen überlegen
 *              2. Längen der Matrizen und somit der for-Schleifen richtig anwenden
 */

public class Matrizenmultiplikation {
    public static void main (String [] args){
        //Test database
        double [][] matrix1 = {{2,1,7},{3,0,3}};
        double [][] matrix2 = {{4,2},{7,1},{5,2}};

        //Execute method and print result
        System.out.println(java.util.Arrays.deepToString(matrixMultiplication(matrix1, matrix2)));

    }

    public static double [] [] matrixMultiplication(double [] [] mat1, double [] [] mat2) {
        //Check whether matrixA and matrixB are able to be multiplicated
        // matrixA [i] [j] & matrixB [j] [k]
        
        for(int i=0;i<mat1.length;i++){
            if(mat1[i].length!=mat2.length || mat1.length != mat2[i].length){
                System.out.println("The matrices aren't able to be multiplicated.\nIssue: Difference of lengths of matrices.");
                return null;
            }
        }
        
        //Initialize returning matrix with specific lengths
        double [] [] endMat = new double [mat1.length] [mat2[0].length]; 

        //Do math 
        for (int i=0;i<mat1.length;i++){

            for (int j=0;j<mat2[0].length;j++){ 

                for (int k=0;k<mat1[0].length;k++){

                    endMat[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return endMat;
    }
}