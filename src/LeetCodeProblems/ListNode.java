package LeetCodeProblems;

public class ListNode {
    public int val;
     public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        ListNode head = this;
        while (head != null) {
            buf.append(head.val + " -> ");
            head = head.next;
        }
        return buf.toString()+"null";
    }
}
