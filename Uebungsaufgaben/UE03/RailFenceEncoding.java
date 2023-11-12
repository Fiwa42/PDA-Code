public class RailFenceEncoding {
    public static void main(String[] args) {
        String text = "gartenzauntransposition";
        char[] sequence = text.toCharArray();

        int numRows = 2;
        int numCols = (int) Math.ceil((double) sequence.length / numRows);
        char[][] matrix = new char[numRows][numCols];

        int count = 0;
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                if (count < sequence.length) {
                    matrix[row][col] = sequence[count];
                    count++;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        char[] sequenceEncoded = new char[sequence.length];
        count = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (matrix[row][col] != ' ') {
                    sequenceEncoded[count] = matrix[row][col];
                    count++;
                }
            }
        }

        String code = String.valueOf(sequenceEncoded);
        System.out.println(code);

        char[] sequenceDecoded = new char[sequence.length];
        count = 0;
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                if (count < sequence.length) {
                    sequenceDecoded[count] = matrix[row][col];
                    count++;
                }
            }
        }

        text = String.valueOf(sequenceDecoded).trim();
        System.out.println(text);
    }
}
