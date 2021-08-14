package LeetCodeProblems;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    static HashMap<Integer, Integer> map1 = new HashMap();
    static HashMap<Integer, Integer> map2 = new HashMap();

    public static void main(String[] args) {
        int coins[] = new int[]{186, 419, 83, 408};
        //int coins[] = new int[]{1, 2, 4, 5};
        int target = 6249;
        /*int coins[] = new int[]{7,9};
        int target=16;*/
        Arrays.sort(coins);
        // System.out.println(getMinimumCoins(coins, target));
        // System.out.println("===========");
        //System.out.println(getMinimumCoins2(coins, target));
        System.out.println(getMinimumCoinsBU(coins, target));
        System.out.println(coinChangeBU(coins, target));
        System.out.println(coinChangeRecurse(coins, target));
    }

    private static Integer getMinimumCoins2(int coins[], int target) {
        Integer min = Integer.MAX_VALUE;
        if (map2.get(target) != null) return map2.get(target);
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            int newTarget = target - coin;
            Integer temp = getMinimumCoins2(coins, newTarget);
            min = Math.min(min, temp);
        }
        if (min == Integer.MAX_VALUE) {
            map2.put(target, Integer.MAX_VALUE);
        } else map2.put(target, Math.min(1 + min, map2.getOrDefault(target, Integer.MAX_VALUE)));

        return map2.get(target);
    }

    private static Integer getMinimumCoins(int[] coins, int target) {
        System.out.println(target);
        if (map1.get(target) != null) return map1.get(target);
        if (target == 0) {
            return 0;
        }
        Integer temp = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= target) {
                temp = Math.min(temp, getMinimumCoins(coins, target - coin));
            }
        }
        if (temp == Integer.MAX_VALUE) map1.put(target, Integer.MAX_VALUE);
        else map1.put(target, temp + 1);
        return map1.get(target);
    }

    // bottomUp..
    private static Integer getMinimumCoinsBU(int[] coins, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    min = Math.min(1 + dp[i - coin], min);
                }
            }
            dp[i] = min;
        }
        //for(int i=0;i<dp.length;i++) System.out.println(dp[i]);

            return dp[target];
    }

    public static int coinChangeBU(int coins[], int target){
        int dp[] = new int[target+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            int min = Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin >=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    min= Math.min(min, dp[i-coin]);
                }
                dp[i] = min != Integer.MAX_VALUE ? min + 1 : min;
            }
        }
        return dp[target];
    }

    public static int coinChangeRecurse(int coins[], int target){
        if(map1.get(target) !=null) return map1.get(target);
        if(target==0){
            return 0;
        }
        int temp = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=target) {
                temp = Math.min(temp,coinChangeRecurse(coins, target - coins[i]));
            }
        }
        map1.put(target,temp != Integer.MAX_VALUE ? temp + 1 : temp);
        return temp != Integer.MAX_VALUE ? temp + 1 : temp;
    }



    }
