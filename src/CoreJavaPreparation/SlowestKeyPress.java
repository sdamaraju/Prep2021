package CoreJavaPreparation;

public class SlowestKeyPress {

    public static void main(String[] args) {
        int[][] keyTimes = new int[][] {{0,2},{1,5},{0,9},{2,15}};
        char c = getMaxElement(keyTimes);
        System.out.println(c);
    }

    private static char getMaxElement(int[][] keyTimes) {
        int max = keyTimes[0][1];
        int maxElement = keyTimes[0][0];
        for(int i=1;i<keyTimes.length;i++){
            if(keyTimes[i][1] - keyTimes[i-1][1] > max){
                max = keyTimes[i][1];
                maxElement = keyTimes[i][0];
            }
        }
        return (char)((int)'a' + maxElement);
    }
}
