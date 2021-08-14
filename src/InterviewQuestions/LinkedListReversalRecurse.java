package InterviewQuestions;

import LeetCodeProblems.ListNode;

public class LinkedListReversalRecurse {

    static ListNode main = null;
    public static void main(String[] args) {


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(node1);
        reverseList(node1, null);
        System.out.println(main);
    }

    static void reverseList(ListNode head, ListNode prev){
        if(head.next == null){
            head.next = prev;
            main = head;
            return;
        }
        reverseList(head.next, head);
        head.next = prev;
    }

}
