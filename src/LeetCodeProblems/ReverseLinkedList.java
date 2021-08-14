package LeetCodeProblems;

public class ReverseLinkedList {

    static class ListNode {
        int data;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.data = 10;
        node.next = new ListNode();
        node.next.data = 20;
        node.next.next = new ListNode();
        node.next.next.data=30;
        node.next.next.next=null;
        ListNode prev = null;
        while(node!=null){
            ListNode temp = node.next;
            node.next = prev;
            prev=node;
            node=temp;
        }
        System.out.println(prev.data + " " + prev.next.data + " " + prev.next.next.data + " " + prev.next.next.next);
    }

}
