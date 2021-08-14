package InterviewQuestions;

public class JumpTheFlag {
    public static void main(String[] args) {
        int maxHeight = 5;
        int a = 1;
        int b = 2;

        getMinimumNumberOfJumpsToReachExactMaxHeight(maxHeight, a ,b);
    }

    private static int getMinimumNumberOfJumpsToReachExactMaxHeight(int maxHeight, int a, int b) {
        return maxHeight/b + maxHeight%b;
    }

}
