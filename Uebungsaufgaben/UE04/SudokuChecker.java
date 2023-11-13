
/*
    Bei dem Logik-Rätsel Sudoku geht es darum, ein 9 × 9 Feld mit den Ziffern von 1 bis 9 so zu füllen,
    dass
        - jede Ziffer nur einmal in jeder Zeile vorkommt,
        - jede Ziffer nur einmal in jeder Spalte vorkommt und
        - jede Ziffer nur einmal in jedem 3 × 3 Teilfeld vorkommt (es gibt neun Teilfelder)

    Links ist ein teilweise ausgefülltes Sudoku-Feld dargestellt. Die Zei-
    len und Spalten sind jeweils von 0 bis 8 durchnummeriert. Die Teil-
    felder sind von links oben bis rechts unten zeilenweise ebenfalls von
    0 bis 8 durchnummeriert (dargestellt in grau). Das Teilfeld rechts
    oben hat beispielsweise die Nummer 2, das Teilfeld links unten hat
    die Nummer 6.
    Dieses Feld enthält drei Fehler: die Ziffer 1 kommt jeweils in Zeile 0,
    in Spalte 6 und in Teilfeld 2 doppelt vor.

    Ergänzen Sie dieses Programm so, dass es das Sudoku-Feld auf Korrektheit bezüglich der drei o.g.
    Kriterien überprüft. Für jeden Fehler soll es die Ziffer und die Position ausgeben. Wenn das Feld
    fehlerfrei ist, soll das Programm nichts ausgeben.
    Für das obige Feld erzeugt das Programm folgende Ausgabe:
    Duplicate number ’1’ in row 0.
    Duplicate number ’1’ in column 6.
    Duplicate number ’1’ in square 2.
    Hinweis: Testen Sie Ihre Lösung auch mit anderen Sudoku-Feldern, die andere Fehler oder auch
    gar keine Fehler enthalten. Sie müssen hier nicht prüfen, ob das Feld die korrekte Größe hat und
    ob es nur mit Ziffern von 0 bis 9 gefüllt ist.
*/

import java.util.Arrays;

public class SudokuChecker {
    public static void main(String[] args) {

        //empty cells are 0
        int [][] sudoku = new int [][] {
            { 0, 9, 0,  0, 0, 0,  1, 1, 0 },
            { 8, 0, 4,  0, 2, 0,  3, 0, 7 },
            { 0, 6, 0,  9, 0, 7,  0, 2, 0 },

            { 0, 0, 5,  0, 3, 0,  1, 0, 0 },
            { 0, 7, 0,  5, 0, 1,  0, 3, 0 },
            { 0, 0, 3,  0, 9, 0,  8, 0, 0 },

            { 0, 2, 0,  8, 0, 5,  0, 6, 0 },
            { 1, 0, 7,  0, 6, 0,  4, 0, 9 },
            { 0, 3, 0,  0, 0, 0,  0, 8, 0 }
        };

        boolean mistake = false;

        //checking if there is a double in a row, except for 0
        for (int row = 0; row < 9 ; row++) {
            for (int col = 0; col < 9; col++) {
                for (int col2 = col + 1; col2 < 9; col2++) {
                    if (sudoku[row][col] == sudoku[row][col2] && sudoku[row][col] != 0) {
                        mistake = true;
                        System.out.println("Duplicate number '" + sudoku[row][col] + "' in row " + row + ".");
                    }
                }
            }
        }

        //checking if there is a double in a column, except for 0
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                for (int row2 = row + 1; row2 < 9; row2++) {
                    if (sudoku[row][col] == sudoku[row2][col] && sudoku[row][col] != 0) {
                        mistake = true;
                        System.out.println("Duplicate number '" + sudoku[row][col] + "' in column " + col + ".");
                    }
                }
            }
        }

        //checking if the squares are correct
        int[] square0 = {sudoku[0][0], sudoku[0][1], sudoku[0][2], sudoku[1][0], sudoku[1][1], sudoku[1][2], sudoku[2][0], sudoku[2][1], sudoku[2][2]};
        Arrays.sort(square0);
        int[] square1 = {sudoku[0][3], sudoku[0][4], sudoku[0][5], sudoku[1][3], sudoku[1][4], sudoku[1][5], sudoku[2][3], sudoku[2][4], sudoku[2][5]};
        Arrays.sort(square1);
        int[] square2 = {sudoku[0][6], sudoku[0][7], sudoku[0][8], sudoku[1][6], sudoku[1][7], sudoku[1][8], sudoku[2][6], sudoku[2][7], sudoku[2][8]};
        Arrays.sort(square2);

        int[] square3 = {sudoku[3][0], sudoku[3][1], sudoku[3][2], sudoku[4][0], sudoku[4][1], sudoku[4][2], sudoku[5][0], sudoku[5][1], sudoku[5][2]};
        Arrays.sort(square3);
        int[] square4 = {sudoku[3][3], sudoku[3][4], sudoku[3][5], sudoku[4][3], sudoku[4][4], sudoku[4][5], sudoku[5][3], sudoku[5][4], sudoku[5][5]};
        Arrays.sort(square4);
        int[] square5 = {sudoku[3][6], sudoku[3][7], sudoku[3][8], sudoku[4][6], sudoku[4][7], sudoku[4][8], sudoku[5][6], sudoku[5][7], sudoku[5][8]};
        Arrays.sort(square5);

        int[] square6 = {sudoku[6][0], sudoku[6][1], sudoku[6][2], sudoku[7][0], sudoku[7][1], sudoku[7][2], sudoku[8][0], sudoku[8][1], sudoku[8][2]};
        Arrays.sort(square6);
        int[] square7 = {sudoku[6][3], sudoku[6][4], sudoku[6][5], sudoku[7][3], sudoku[7][4], sudoku[7][5], sudoku[8][3], sudoku[8][4], sudoku[8][5]};
        Arrays.sort(square7);
        int[] square8 = {sudoku[6][6], sudoku[6][7], sudoku[6][8], sudoku[7][6], sudoku[7][7], sudoku[7][8], sudoku[8][6], sudoku[8][7], sudoku[8][8]};
        Arrays.sort(square8);



        for (int i = 1; i < square0.length; i++) {
            if (square0[i] == square0[i - 1] && square0[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square0[i] + "' in square 0.");
            }

            if (square1[i] == square1[i - 1] && square1[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square1[i] + "' in square 1.");
            }

            if (square2[i] == square2[i - 1] && square2[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square2[i] + "' in square 2.");
            }

            if (square3[i] == square3[i - 1] && square3[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square3[i] + "' in square 3.");
            }

            if (square4[i] == square4[i - 1] && square4[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square4[i] + "' in square 4.");
            }

            if (square5[i] == square5[i - 1] && square5[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square5[i] + "' in square 5.");
            }

            if (square6[i] == square6[i - 1] && square6[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square6[i] + "' in square 6.");
            }

            if (square7[i] == square7[i - 1] && square7[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square7[i] + "' in square 7.");
            }

            if (square8[i] == square8[i - 1] && square8[i] != 0) {
                mistake = true;
                System.out.println("Duplicate number '" + square8[i] + "' in square 8.");
            }
        }

        //tells if the sudoku has a mistake or not
        if (mistake) {
            System.out.println("THERE IS A MISTAKE!");
        } else {
            System.out.println("THE SUDOKU IS CORRECT!");
        }
    }
}