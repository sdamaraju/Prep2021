package Karumanchi;

import Karumanchi.TreeNode;

import java.util.Stack;

public class LeastCommonAncestor {

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
        System.out.println(leastCommonAncestor(node1, 6, 7          ));
    }

    private static int leastCommonAncestor(TreeNode<Integer> root, int a, int b) {
        Stack path1  = new Stack();
        Stack path2  = new Stack();
        int leastCommonAncestor = -1;
        findPath1(root, a, path1);
        findPath1(root, b, path2);
        while (!path1.isEmpty() && !path2.isEmpty()){
            int var1 = (int) path1.pop();
            int var2 = (int) path2.pop();
            if(var1 != var2){
                return leastCommonAncestor;
            } else leastCommonAncestor = var1;
        }
        return leastCommonAncestor;
    }

    private static boolean findPath(TreeNode<Integer> root, int val, Stack list) {
        if (root == null) return false;
        if (root.data == val) {
            list.push(root.data);
            return true;
        }
        if (root.left != null) {
            boolean left = findPath(root.left, val, list);
            if(left) {
                list.push(root.data);
                return true;
            }
        }
        if (root.right != null) {
            boolean right = findPath(root.right, val, list);
            if(right) {
                list.push(root.data);
                return true;
            }
        }
        return false;
    }

    public static boolean findPath1(TreeNode root, int val, Stack st){
        if(root == null) return false;
        if ((int)root.data == val) {
            st.push(root.data);
            return true;
        }
        boolean leftFound = findPath(root.left, val, st);
        if(leftFound) {
            st.push(root.data);
            return true;
        }
        boolean rightFound = findPath(root.right, val, st);
        if(rightFound) {
            st.push(root.data);
            return true;
        }
        return false;
    }


}
