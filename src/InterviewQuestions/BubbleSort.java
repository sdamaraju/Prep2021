package InterviewQuestions;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();

        int nums[] = new int[] {4,3,5,6,7,8};
        for(int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-1;j++){
                if(nums[j+1] < nums[j]){
                    int temp= nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
                continue;
            }
        }
        for (int num:nums) System.out.println(num);
        System.out.println("====");

        nums = new int[] {4,3,5,6,7,8};
        for(int i=0;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j=i;j<nums.length;j++){
                if(nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIndex] = temp;
        }
        for (int num:nums) System.out.println(num);

    }

}
