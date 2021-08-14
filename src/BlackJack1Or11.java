public class BlackJack1Or11 {
    static Integer max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //System.out.println(getMaxPossibleSum(2, 11));
        System.out.println(getMaxPossibleSumEfficient(12, 1));
    }

    private static int getMaxPossibleSum(int sum, int count) {
        if (sum > 21) return Integer.MIN_VALUE;
        if (count == 0) return sum;
        int sum1 = getMaxPossibleSum(sum + 1, count - 1);
        int sum11 = getMaxPossibleSum(sum + 11, count - 1);
        max = Math.max(max, Math.max(sum1, sum11));
        return max;
    }
    private static int getMaxPossibleSumEfficient (int sum, int count) {
        if(sum > 10) return sum + count;
        if((21 - sum) % 11 < count - 1){
            return  sum + count;
        }
        else return sum + 11 + count - 1;

    }

}
