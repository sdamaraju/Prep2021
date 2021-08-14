package LeetCodeProblems;

public class MinSwaps {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 0, 1, 0, 1};
        int minSwaps = Integer.MAX_VALUE;
        int swapCount = 0;
        int firstIndex = 0;
        int firstSwapIndex = -1;
        int target1s = 0;
        int temp1s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) target1s++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(temp1s < target1s) {
                if (arr[i] == 1) {
                    temp1s++;
                } else if (arr[i] == 0 && firstSwapIndex == -1) {
                    firstSwapIndex = i;
                    swapCount++;
                    temp1s++;
                } else if (arr[i] == 0) {
                    swapCount++;
                    temp1s++;
                }
            } else {
                if(swapCount < minSwaps) minSwaps =swapCount;
                firstIndex++;
                temp1s--;
            }
        }
        System.out.println(minSwaps);
    }
}
