package LeetCodeProblems;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        // Use pointers and implement.
        /*int[] input = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 7, 8, 9, 9};*/
        /*int[] input = new int[]{1,2,3,4,5,5,5,6};*/
        int[] input = new int[]{1,2,2};
        //int op = removeDups(input);
        int op2 = removeDups2(input);
        System.out.println(op2);

    }

    private static int removeDups(int[] input) {
        int opLength = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            if (i == input.length - 1) {
                opLength++;
                continue;
            }
            if (input[i] == input[i + 1]) {
                for (int j = i; j < input.length - 1; j++) {
                    input[j] = input[j + 1];
                }
            } else opLength++;
        }
        System.out.println(opLength);
        return opLength;
    }

    private static int removeDups2(int[] input) {
        if(input.length==1) return 1;
        int slow = 1;
        int fast = 1;
        int prev = 0;
        boolean ret = false;
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                prev = input[i];
                continue;
            }
            if (input[fast] <= prev) {
                ret = true;
                for (int j = fast + 1; j < input.length; j++) {
                    if (input[j] <= prev) {
                        fast++;
                    }
                    else {
                        fast = j;
                        ret = false;
                        break;
                    }
                }
                if(ret){
                    return slow;
                }
                input[slow] = input[fast];
                prev = input[slow];
                slow++;

            } else {
                prev = input[fast];
                input[slow] = input[fast];
                slow++;
                fast++;
            }

        }
        return slow;
    }

}
