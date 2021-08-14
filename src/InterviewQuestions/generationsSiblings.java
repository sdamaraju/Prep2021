package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class generationsSiblings {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(getSiblings(arr,10));
    }

    private static List<Integer> getSiblings(int[] arr, int person) {
        int position = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == person) position=i;
        }
        if(position == -1) return null;
        else{
            Double val = Math.floor(Math.log10(position+1)/Math.log10(2));
            Double index = Math.pow(2,val);
            Double dest = Math.pow(2,val+1);
            List results = new ArrayList();
            for(Double i = index;i<dest;i++){
                if(i > arr.length ) return results;
                if(i.intValue()==person) continue;
                else results.add(arr[i.intValue()-1]);
            }
            return results;
        }
    }
}
