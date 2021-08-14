package LeetCodeProblems;

public class JumpGame {
    public static void main(String[] args) {
        int nums[] = new int [] {3,2,1,0,4};
        int carryAdd = 0;
        for(int i=nums.length-2;i>=0;i--){
            System.out.println(carryAdd + "" + i);
            if(i==0) {
                if(carryAdd>0 && nums[i]<carryAdd+1) System.out.println("Failed");
                else System.out.println("Passsed");
            } else {
                if(carryAdd == 0){
                    if(nums[i]>=1) continue;
                    else carryAdd++;
                } else {
                    if(nums[i]>=1+carryAdd) {
                        carryAdd = 0;
                    } else {
                        carryAdd++;
                    }
                    continue;
                }
            }
        }
    }
}
