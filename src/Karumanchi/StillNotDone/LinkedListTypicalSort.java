package Karumanchi.StillNotDone;

import LeetCodeProblems.ListNode;

import java.util.List;

public class LinkedListTypicalSort {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(typicalSort(head, 3));
        /*ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        System.out.println(typicalSort(head,2));*/
    }

    private static ListNode typicalSort(ListNode head, int value) {
        ListNode beforeHead = null;
        ListNode before = null;
        ListNode after = null;
        ListNode afterHead = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < value) {
                if (before == null) {
                    beforeHead = new ListNode(temp.val);
                    before = beforeHead;
                } else {
                    before.next = new ListNode(temp.val);
                    before = before.next;
                }
            } else if (temp.val == value) {
                if (after == null) {
                    afterHead = new ListNode(temp.val);
                    after = afterHead;
                } else {
                    after.next = new ListNode(temp.val);
                    after = after.next;
                }
            } else {
                if (after == null) {
                    afterHead = new ListNode(temp.val);
                    after = afterHead;
                } else {
                    after.next = new ListNode(temp.val);
                    after = after.next;
                }
            }
            temp = temp.next;
        }
        ListNode op = null;
        ListNode opHead = null;
        while (beforeHead != null) {
            if (op == null) {
                opHead = new ListNode(beforeHead.val);
                op = opHead;
            } else {
                op.next = new ListNode(beforeHead.val);
                op = op.next;
            }
            beforeHead = beforeHead.next;
        }
        if(op!=null) {
            op.next = afterHead;
        }
        else {
            opHead = afterHead;
        }
        return opHead;
    }
}
