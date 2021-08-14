package LeetCodeProblems;

import java.util.HashMap;

public class ClimbingSteps {


    public static void main(String[] args) {
        ClimbingSteps x = new ClimbingSteps();

        int target = 3;
        // System.out.println((x.climbingSteps(target)));
      //  System.out.println((x.climbingSteps2(target)));
       System.out.println((climbingSteps3(target)));
        System.out.println((climbingSteps2(target)));
        System.out.println((minNumberofclimbingStairsBottomUP(target)));
    }

    private static int climbingSteps3(int target) {
        HashMap map = new HashMap();
        int a = climbingSteps3Recurse(1, 0,target, map);
        int b = climbingSteps3Recurse(2, 0,target, map);
        return a+b;
    }

    private static int climbingSteps3Recurse(int step, int stepsTillNow, int target, HashMap<Integer,Integer> map) {
        if(map.get(stepsTillNow+step) != null) return map.get(stepsTillNow+step);
        if(stepsTillNow + step > target) return 0;
        if(stepsTillNow + step == target) return 1;
        else {
            int step1 = climbingSteps3Recurse(1, stepsTillNow + step, target, map);
            int step2 = climbingSteps3Recurse(2, stepsTillNow + step, target, map);
            map.put(stepsTillNow + step,step1+step2);
            return step1 + step2;
        }
    }

    private static int minNumberofclimbingStairsBottomUP(int target){
        int dp[] = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<dp.length;i++){
            dp[i] = 1 + Math.min(dp[i-1],dp[i-2]);
        }
        return dp[target];
    }

    private int climbingSteps(int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int a = climbSteps(1, 0, target);
        int b = climbSteps(2, 0, target);
        return a + b;
    }

    private int climbSteps(int currentStep, int stepCount, int target) {
        if (currentStep + stepCount > target) {
            return 0;
        }
        if (currentStep + stepCount == target) {
            return 1;
        }
        if (currentStep + stepCount < target) {
            int x = climbSteps(1, currentStep + stepCount, target);
            int y = climbSteps(2, currentStep + stepCount, target);

            return x + y;
        }

        return 0;
    }

    private static int climbingSteps2(int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int a = climbSteps2(1, 0, target, map);
        int b = climbSteps2(2, 0, target, map);
        return a + b;
    }

    private static int climbSteps2(int currentStep, int stepCount, int target, HashMap map) {
        if (map.get(currentStep + stepCount) != null) {
            return (Integer) map.get(currentStep + stepCount);
        }
        if (currentStep + stepCount > target) {
            return 0;
        }
        if (currentStep + stepCount == target) {
            return 1;
        }
        if (currentStep + stepCount < target) {
            int x = climbSteps2(1, currentStep + stepCount, target, map);
            int y = climbSteps2(2, currentStep + stepCount, target, map);
            map.put(currentStep + stepCount,x+y);
            return x + y;
        }

        return 0;
    }



}
