package LeetCodeProblems;

public class StringZigZag {
    public static void main(String[] args) {
        int rows = 3;
        String str = "PAYPALISHIRING";
        Character zigzag[][] = (convertStringToZigZag(str, rows));
        int cols = identifyNumberOfColumns(str.length(),rows );
        for (int i = 0; i < rows; i++) {
            System.out.println("");
            for (int j = 0; j < cols; j++) {
                System.out.print(zigzag[j][i] + " ");
            }
        }
        System.out.println("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(zigzag[j][i] != ' ' ? zigzag[j][i] : "");
            }
        }

    }

    private static Character[][] convertStringToZigZag(String str, int rows) {
        int cols = identifyNumberOfColumns(str.length(), rows);
        Character[][] zigzag = new Character[cols][rows];
        boolean fullColumn = true;
        int k = 0;
        int immediateFullColumn = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (fullColumn) {
                    zigzag[i][j] = k < str.length() ? str.charAt(k++) : ' ';
                    if (j == rows-1) fullColumn = false;
                    immediateFullColumn = i;
                } else {
                    if (j == rows - (i - immediateFullColumn + 1)){
                        zigzag[i][j] = k < str.length() ? str.charAt(k++) : ' ';
                    }else{
                        zigzag[i][j] = ' ';
                    }
                    if(i - immediateFullColumn + 1 == rows){
                        fullColumn = true;
                    }
                }
            }
        }
        return zigzag;
    }

    private static int identifyNumberOfColumns(int lengthOfStr, int rows) {
        int numberOfColumns = 0;
        int i = 0;
        boolean fullColumn = false;
        while (i <= lengthOfStr) {
            if (!fullColumn) {
                i = i + rows;
                fullColumn = true;
                numberOfColumns++;
            } else {
                if ((lengthOfStr - i) < rows - 2) numberOfColumns = numberOfColumns + (lengthOfStr - i);
                else numberOfColumns = numberOfColumns + (rows - 2);
                i = i + (rows - 2);
                fullColumn = false;
            }
        }
        return numberOfColumns;
    }

}
