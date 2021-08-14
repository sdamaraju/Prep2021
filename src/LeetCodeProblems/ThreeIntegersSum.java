package LeetCodeProblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ThreeIntegersSum {

    public static void main(String[] args) {
        int input[] = new int[]{-1, 2, 1, 4};
        int target = 1;
        int value = getThreeIntegersSum(input, target);
        int value2 = getThreeIntegersSumUsingMap(input, target);
        //System.out.println(value);
        System.out.println(value2);
    }

    private static int getThreeIntegersSum(int[] input, int target) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < input.length; k++) {
                    if (i == k || j == k) continue;
                    int curr = Math.abs(input[i] + input[j] + input[k] - target);
                    if (curr < min) {
                        min = curr;
                    }
                }
            }
        }
        return min;
    }

    private static int getThreeIntegersSumUsingMap(int[] input, int target) {
        HashMap<Integer, int[]> map = new HashMap();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j) continue;
                map.put(input[i] + input[j], new int[]{i, j});
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            Set set = map.entrySet();
            Iterator<Map.Entry> it = set.iterator();
            while (it.hasNext()) {
                Map.Entry entry = it.next();
                int[] indices = (int[]) entry.getValue();
                if (indices[0] == i || indices[1] == i) {
                    if(it.hasNext()) it.next();
                    continue;
                }
                if (Math.abs(input[i] + (Integer) entry.getKey() - target) < min) {
                    min = input[i] + (Integer) entry.getKey();
                }
            }
        }
        return min;
    }


}
