import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeIntegersSumTriplets {

    public static void main(String[] args) {
        int input[] = new int[]{-1, 0, 1, -4, 2, -1};
        int target = 1;
        int value = getThreeIntegersSum(input, 0);
    }

    private static int getThreeIntegersSum(int[] input, int target) {
        Arrays.sort(input);
       /*for(int i=0;i<input.length;i++)
        System.out.println(input[i]);*/
        int sum = 0;
        int k = input.length - 1;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j || j == k || i == k) continue;
                while (k > j) {
                    sum = input[i] + input[j] + input[k];
                    if (sum > target) {
                        k--;
                    } else if (sum == target) {
                        System.out.println(input[i] + " " + input[j] +" " + input[k]);
                        k--;
                    } else {
                        break;
                    }
                }
                k = input.length -1;
            }
        }

        return 0;
    }
}
