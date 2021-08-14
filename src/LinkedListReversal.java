import LeetCodeProblems.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LinkedListReversal {

    public static void main(String[] args) {

        System.out.println(Math.log(8));
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(node1);
        reverseList(node1);
    }

    static void reverseList(ListNode head){
        ListNode node = head;
        ListNode temp = null;
        ListNode prev = null;
        while(node != null){
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        System.out.println(prev);

    }


}
