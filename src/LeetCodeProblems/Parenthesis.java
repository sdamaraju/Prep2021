package LeetCodeProblems;

import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        String input = "()[";
        Stack st = new Stack();
        boolean passed = true;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{'){
                st.push(input.charAt(i));
                count++;
            } else {
                count--;
                if(st.isEmpty()) {passed=false; break;}
                char popped = (char)st.pop();
                if((popped == '(' && input.charAt(i) != ')') || (popped == '{' && input.charAt(i) != '}') || (popped == '[' && input.charAt(i) != ']')){
                    passed = false;
                    break;
                }
            }
        }
        if(passed && count==0) System.out.println("Passed"); else System.out.println("Failed");
    }
}
