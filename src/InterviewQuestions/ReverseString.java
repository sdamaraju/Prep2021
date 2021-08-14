package InterviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Teja";
        reverse1(str);
        reverse2(str);
        StringBuffer op = new StringBuffer();
        reverse3(str,op);
        System.out.println(op.toString());
    }

    private static void reverse1(String str) {
        char[] strArr = str.toCharArray();
        int start = 0;
        int end = strArr.length - 1;
        char temp;
        while (end > start) {
            temp = strArr[end];
            strArr[end] = strArr[start];
            strArr[start] = temp;
            end--;
            start++;
        }
        System.out.println(Arrays.toString(strArr));
    }

    private static void reverse2(String str) {
        Stack st = new Stack();
        int i = 0;
        while (i <= str.length() - 1) {
            st.push(str.charAt(i++));
        }
        StringBuffer b = new StringBuffer();
        while (!st.isEmpty()) {
            b.append(st.pop());
        }
        System.out.println(b.toString());
    }

    private static void reverse3(String str, StringBuffer op) {
        if(str.length() == 1) op.append(str.charAt(0));
        else {
            reverse3(str.substring(1),op);
            op.append(str.charAt(0));
        }
    }
}