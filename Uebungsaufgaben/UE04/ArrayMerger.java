/*
 * Zwei sortierte Arrays sollen gemischt werden, so dass ein ebenfalls sortiertes Gesamt-Array her-
 * auskommt. Vervollständigen Sie dazu folgendes Programm:
 * 
 * Mögliches Verfahren: Erstellen Sie ein Ergebnis-Array der richtigen Länge. Legen Sie für beide
 * Eingabe-Arrays jeweils einen aktuellen Index an. Durchlaufen Sie die beiden Arrays. Vergleichen
 * Sie die beiden Elemente am jeweils aktuellen Index. Fügen Sie das jeweils kleinere Element in
 * das Ergebnis-Array ein und erhöhen Sie den dazu gehörenden aktuellen Index.
 * Sie dürfen dabei das Ergebnis-Array nicht noch einmal sortieren, die korrekte Reihenfolge muss
 * bereits beim zusammenfügen hergestellt werden.
 */

public class ArrayMerger {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 3, 5, 6, 9};
        int[] array2 = {2, 3, 5, 7, 8, 9, 10};
        int[] result = merge(array1, array2);


        for ( int i = 0; i < result . length ; i ++) {
            System.out.print(result[i] + " ");
        }
        //output: 1 2 3 3 3 5 5 6 7 8 9 9 10
    }


    //merge two int arrays
    static int[] merge (int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0;
        int index1 = 0;
        int index2 = 0;

        //merging arrays when they are the same length
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] <= array2[index2]) {
                result[i] = array1[index1];
                i++;
                index1++;
            } else {
                result[i] = array2[index2];
                i++;
                index2++;
            }
        }

        //merging when array1 is longer
        while (index1 < array1.length) {
            result[i] = array1[index1];
            i++;
            index1++;
        }

        //merging when array2 is longer
        while (index2 < array2.length) {
            result[i] = array2[index2];
            i++;
            index2++;
        }
        return result;
    }
}