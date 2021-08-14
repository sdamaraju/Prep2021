package LeetCodeProblems;

import java.util.Stack;

public class ListNodeTwoSum {

    public static void main(String[] args) {
        ListNode operand1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode operand2 = new ListNode(15, new ListNode(6, new ListNode(4, null)));
        ListNode output = sum(operand1, operand2);
        ListNode output2 = sumReverseOrder(operand1, operand2);
        System.out.println(output);
        System.out.println(output2);
    }

    private static ListNode sum(ListNode operand1, ListNode operand2) {
        ListNode result = new ListNode(0, null);
        ListNode returnResult = result;
        int carry = 0;
        while (operand1 != null || operand2 != null || carry != 0) {
            int sum = ((operand1 == null) ? 0 : operand1.val) + ((operand2 == null) ? 0 : operand2.val) + carry;
            result.val = sum % 10;
            carry = sum / 10;
            if (operand1 != null) operand1 = operand1.next;
            if (operand2 != null) operand2 = operand2.next;
            if (operand1 == null && operand2 == null && carry == 0) break;
            result.next = new ListNode(0, null);
            result = result.next;
        }
        return returnResult;
    }

    private static ListNode sumReverseOrder(ListNode operand1, ListNode operand2) {
        ListNode result = new ListNode(0, null);
        ListNode returnResult = result;
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        Stack<Integer> s3 = new Stack();
        populateStack(s1, operand1);
        populateStack(s2, operand2);
        System.out.println(s1);
        System.out.println(s2);
        int carry = 0;
        while (!s1.isEmpty() || !s1.isEmpty() || carry != 0) {
            int sum = ((s1.isEmpty()) ? 0 : s1.pop()) + ((s2.isEmpty()) ? 0 : s2.pop()) + carry;
            s3.push(sum % 10);
            carry = sum / 10;
            if (s1.isEmpty() && s2.isEmpty() && carry == 0) break;
        }
        while (!s3.isEmpty()) {
            result.val = s3.pop();
            if (!s3.isEmpty()) result.next = new ListNode(0, null);
            result = result.next;
        }
        return returnResult;
    }

    private static void populateStack(Stack s, ListNode operand) {
        while (operand != null) {
            s.push(operand.val);
            operand = operand.next;
        }
    }


}
