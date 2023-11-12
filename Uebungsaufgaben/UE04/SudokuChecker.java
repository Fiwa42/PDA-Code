
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

        if (mistake) {
            System.out.println("THERE IS A MISTAKE");
        }
    }
    
}
