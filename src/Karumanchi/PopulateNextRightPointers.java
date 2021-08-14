package Karumanchi;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {

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
        node2.right = node5;

        node3.right = node7;
        TreeNode op = populateNextRightPointers(node1);
        TreeNode op1 = recurseWay(node1);
        System.out.println(op);
        System.out.println(op.left);
        System.out.println(op.right);
        System.out.println(op.left.left);
        System.out.println(op.left.right);
        System.out.println(op.right.left);
        System.out.println(op.right.right);
    }

    public static TreeNode populateNextRightPointers(TreeNode root) {
        TreeNode returnRoot = root;
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return null;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr != null) {
                curr.next = queue.isEmpty() ? null : queue.peek();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            } else {
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return returnRoot;
    }

    public static TreeNode recurseWay(TreeNode root) {
        if (root == null) return null;
        root.next = null;
        populateNextRightPointers_recurse(root);
        return root;
    }

    public static void populateNextRightPointers_recurse(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left != null ? root.next.left : root.next.right;
            }
        }
        populateNextRightPointers_recurse(root.left);
        populateNextRightPointers_recurse(root.right);
    }


}
