package InterviewQuestions;

import java.util.HashMap;

public class BalancingElements {
    public static void main(String[] args) {
        int[] elements = new int[]{2,2,2};
        int ans = getBalancingElements(elements);
        System.out.println(ans);
    }

    private static int getBalancingElements(int[] elements) {
        HashMap<Integer, int[]> map = new HashMap();
        int oddSum = 0;
        int evenSum = 0;
        int count=0;
        for (int i = elements.length - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                evenSum += elements[i];
            } else {
                oddSum += elements[i];
            }
            map.put(i,new int[]{evenSum, oddSum});
        }
        for (int i = elements.length - 1; i >= 0; i--) {
            int tempOddSum = 0;
            int tempEvenSum = 0;
            if (i % 2 == 0) {
                if(i+1 == elements.length) {
                    if(((oddSum == evenSum - elements[i]))) count++;
                    continue;
                }
                tempEvenSum = evenSum - elements[i] + map.get(i+1)[1] - map.get(i+1)[0];
                tempOddSum = oddSum - map.get(i+1)[1] + map.get(i+1)[0];
            } else {
                if(i+1 == elements.length){
                    if (((oddSum - elements[i] == evenSum)))count++;
                    continue;
                }
                tempOddSum = oddSum - elements[i] + map.get(i+1)[0] - map.get(i+1)[1];
                tempEvenSum = evenSum - map.get(i+1)[0] + map.get(i+1)[1];
            }
            if(tempEvenSum == tempOddSum) count++;
        }
        return count;
    }

}
