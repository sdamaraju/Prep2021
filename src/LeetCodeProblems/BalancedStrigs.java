package LeetCodeProblems;

public class BalancedStrigs {

    public static void main(String[] args) {
        //String input = "RLRRLLRLRL";
        String input = "RLRRRLLRLL";
        //String input = "LLLLRRRR";
        //String input = "RLLLLRRRLR";

        System.out.println(getBalancedSubstringsCount(input));
    }

    private static int getBalancedSubstringsCount(String bs) {
        int subStringCount = 0;
        int countR = 0;
        int countL = 0;
        for (int i = 0; i < bs.length(); i++) {
            if (bs.charAt(i) == 'R') {
                countR++;
            } else {
                countL++;
            }
            if (countL == countR) {
                subStringCount++;
                countL = 0;
                countR = 0;
            }
        }
        return subStringCount;
    }

}
