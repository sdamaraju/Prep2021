package LeetCodeProblems;

import java.util.HashMap;

public class CheckArrayFormationThroughConcatenation{

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<pieces.length;i++){
            if(pieces[i].length>1){
                if(map.get(pieces[i][0])!=null) {
                    int arrIndex = map.get(pieces[i][0]);
                    for (int k = 1; k < pieces[i].length; k++) {
                        arrIndex++;
                        if (arr.length <= arrIndex) {
                            return false;
                        }
                        if (arr[arrIndex] != pieces[i][k]) {
                            return false;
                        }
                    }
                /*for(int j=arrIndex+1,k=1;j<arr.length;j++)
                    if(arr[j]!=pieces[i][k++]){
                        return false;
                    }
                }*/
                }else {
                    return false;
                }
            }else {
                if(map.get(pieces[i][0]) == null){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,5,7};
        int pieces [][] = {{2,4,6,8}};
        System.out.println("The result is " + canFormArray(arr,pieces));
    }

}
