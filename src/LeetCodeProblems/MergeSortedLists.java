package LeetCodeProblems;

import java.util.ArrayList;

public class MergeSortedLists {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        ArrayList list2 = new ArrayList();
        list2.add(2);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        //ArrayList result = merge(list1, list2);
        ListNode linkedList1 = new ListNode(2, null);//new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode linkedList2 = new ListNode(1, null);//new ListNode(4, new ListNode(5, new ListNode(6, null))));
        ListNode resultLinkedList = merge(linkedList1,linkedList2);
        System.out.println(resultLinkedList);
        //System.out.println(result);
    }

    static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> result = new ArrayList();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) result.add(l1.get(i++));
            else if (l1.get(i) > l2.get(j)) result.add(l2.get(j++));
            else {
                result.add(l1.get(i++));
                result.add(l2.get(j++));
            }
        }
        if (i >= l1.size()) {
            while (j < l2.size()) {
                result.add(l2.get(j++));
            }
        } else if (j >= l2.size()) {
            while (i < l1.size()) {
                result.add(l1.get(i++));
            }
        }
        return result;
    }

    static ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode pointer = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (result == null) {
                    result = new ListNode(l1.val, null);
                    pointer = result;
                } else {
                    pointer.next = new ListNode(l1.val, null);
                    pointer = pointer.next;
                }
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                if (result == null) {
                    result = new ListNode(l2.val, null);
                    pointer=result;
                } else {
                    pointer.next = new ListNode(l2.val, null);
                    pointer=pointer.next;
                }
                l2 = l2.next;
            } else {
                if (result == null) {
                    result = new ListNode(l2.val, new ListNode(l1.val, null));
                    pointer = result.next;
                } else {
                    pointer.next = new ListNode(l2.val, new ListNode(l1.val, null));
                    pointer=pointer.next.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            while (l2 != null) {
                if (result == null) {
                    result = new ListNode(l2.val, null);
                    pointer = result;
                } else {
                    pointer.next = new ListNode(l2.val, null);
                    pointer=pointer.next;
                }
                l2 = l2.next;
            }
        } else if (l2 == null) {
                while (l1 != null) {
                    if (result == null) {
                        result = new ListNode(l1.val, null);
                        pointer = result;
                    } else {
                        pointer.next = new ListNode(l1.val, null);
                        pointer=pointer.next;
                    }
                    l1 = l1.next;
                }
        }
        return result;
    }
}
