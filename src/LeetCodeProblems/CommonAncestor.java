package LeetCodeProblems;

import java.util.Stack;

public class CommonAncestor {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(6,null,null),null),null),new TreeNode(5,null,null));
        System.out.println(commonAncestor(node, 6,5));
    }

    private static boolean commonAncestor(TreeNode root, int i, int k) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        commonAncestorRecurse(root, i, s1);
        commonAncestorRecurse(root, k, s2);
        //compare and pop non common data from stacks
        System.out.println(s1.peek());
        System.out.println(s2.peek());
        return false;
    }

    private static boolean commonAncestorRecurse(TreeNode root, int i, Stack<Integer> s) {
        if(root == null) return false;
        if(root.val == i) return true;
        if(root.val != i){
            boolean left = commonAncestorRecurse(root.left, i, s);
            if(left) {
                s.push(root.val);
                return true;
            }
            boolean right= commonAncestorRecurse(root.right, i, s);
            if(right) {
                s.push(root.val);
                return true;
            }
        }
        return false;
    }
}
