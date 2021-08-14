package Karumanchi;

import java.util.Stack;

public class CommonAncestorRevisit {
    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node6;
        node4.right = node7;
        node7.left = node5;
        System.out.println(leastCommonAncestor(node1, 2,4));
    }

    private static int leastCommonAncestor(TreeNode<Integer> node1, int root1, int root2) {
        Stack<TreeNode> st1 = new Stack();
        Stack<TreeNode> st2 = new Stack();
        getPath(node1,root1,st1);
        getPath(node1,root2,st2);
        int cans = -1;
        if(st1.isEmpty() || st2.isEmpty()){
            return -1;
        }
        else {
            while(!st1.isEmpty() && !st1.isEmpty()){
                int l = (int)st1.pop().data;
                int r = (int)st2.pop().data;
                if(l != r){
                    return cans;
                }else cans = l;
            }
        }
        return cans;
    }

    private static boolean getPath(TreeNode<Integer> node, int root, Stack st) {
        if(node == null) return false;
        if(node.data == root){
            st.push(node);
            return true;
        }
        if(getPath(node.left, root, st)){
            st.push(node);
            return true;
        }
        if(getPath(node.right, root, st)) {
            st.push(node);
            return true;
        }
        return false;
    }
}
