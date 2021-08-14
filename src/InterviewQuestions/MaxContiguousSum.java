package InterviewQuestions;

public class MaxContiguousSum {
    public static void main(String[] args) {
        int nums[] = new int[]{-3,-2,-1};
        //int nums[] = new int[]{-1,-1,-2,-2};
        System.out.println(getMaxContiguousSum2(nums));
    }

    private static int getMaxContiguousSum(int[] nums) {
        int maxSum = nums[0];
        int intervalSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > intervalSum && intervalSum < 0) {
                maxSum = nums[i];
                intervalSum = maxSum;
            } else if (nums[i] + intervalSum >= 0 && nums[i] + intervalSum < intervalSum) {
                intervalSum = intervalSum + nums[i];
            } else if (nums[i] > 0) {
                intervalSum = intervalSum + nums[i];
                maxSum = intervalSum > maxSum ? intervalSum : maxSum;
            } else if(nums[i] + intervalSum < intervalSum) {
                maxSum = intervalSum > maxSum ? intervalSum : maxSum;
                intervalSum=Integer.MIN_VALUE;
                continue;
            }

        }
        return maxSum;
    }

    private static int getMaxContiguousSum2(int[] nums) {
        int maxSum = nums[0];
        int intervalSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //if(nums[i] + intervalSum > 0){
                intervalSum = Math.max(nums[i], intervalSum+nums[i]);
                maxSum = intervalSum > maxSum ? intervalSum : maxSum;
            //} else {
            //    intervalSum = 0;
            //    continue;
           // }

        }
        return maxSum;
    }
}
