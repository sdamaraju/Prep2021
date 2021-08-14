package InterviewQuestions;

public class SortedArrangement {

    public static void main(String[] args) {
        int [] values = new int[] {2,5,6,10,12,14,15};
        int operations = getOperations(values,12);
        System.out.println(operations);
    }

    private static int getOperations(int[] values, int target) {
        if (target <= values[0] || target >= values[values.length-1]) return 1;
        int identifyIndex = binarySearch(values, 0, values.length-1, target);
        return Math.min(1+((identifyIndex+1)*2),(values.length-identifyIndex-1)*2+1);
    }

    private static int binarySearch(int[] values, int l, int r, int target) {
        System.out.println(l + "" + r);
        if(r-l == 1){
            if(values[l] == target){

            }
            if(values[r] ==target){

            }
           return l;
        }
        int m = (l+r)/2;
        if(target > values[m]) return binarySearch(values, m,r, target);
        else return binarySearch(values, l,m, target);
    }
}
