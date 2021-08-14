public class FindMissingNumber {

    public static void main(String[] args) {
        int [] ints = {1,6,5,4,2};
        //First n integers, missing 1 integer, n=6
        int sum = 0;
        for(int i=0;i<ints.length;i++){
            sum = sum + ints[i];
        }
        int totalSum = (6 * 7)/2;
        System.out.println("Missing number is :" + (totalSum-sum));
    }

}
