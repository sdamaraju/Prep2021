package LeetCodeProblems;

public class OneEditDistance {
    static int editCount = 0;

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("", "aa "));
    }

    private static boolean isOneEditDistance(String src, String dest) {
        if (Math.abs(src.length() - dest.length()) > 1) return false;

        if (src.length() == 0 && dest.length() == 1 || src.length() == 1 && dest.length() == 0) {
            if (editCount == 1) return false;
            else return true;
        }

        if (src.length() == dest.length() && src.length() == 0) {
            if (editCount == 1) return true;
            else return false;
        }

        if (src.charAt(0) == dest.charAt(0)) {
            return isOneEditDistance(src.length() > 1 ? src.substring(1) : "", dest.length() > 1 ? dest.substring(1) : "");
        } else {
            if (editCount == 0) {
                editCount++;
                return isOneEditDistance(src.substring(1), dest) ||
                        isOneEditDistance(src, dest.substring(1)) ||
                        isOneEditDistance(src.substring(1), dest.substring(1));
            } else return false;
        }
    }
}
