package LeetCodeProblems;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 0, 0, 0, 0};
        int m = 3;
        int[] input2 = new int[]{0, 2, 2, 2};
        int n = 4;
        merge(input1, input2, m, n);
        for (int i = 0; i < input1.length; i++) System.out.println(input1[i]);
    }

    private static void merge(int[] input1, int[] input2, int n1, int n2) {
        int j = n1 - 1;
        int k = n2 - 1;
        for (int i = input1.length - 1; i >= 0; i--) {
            if (j < 0){
                input1[i] = input2[k];
                k--;
                continue;
            }
            if (k < 0){
                input1[i] = input1[j];
                j--;
                continue;
            }
            if (input1[j] > input2[k]) {
                input1[i] = input1[j];
                j--;
            } else if (input1[j] < input2[k]) {
                input1[i] = input2[k];
                k--;
            } else {
                input1[i] = input1[j];
                j--;
            }
        }
    }
}
