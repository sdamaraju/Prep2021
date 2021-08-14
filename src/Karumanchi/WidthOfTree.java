package Karumanchi;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfTree {
    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node10 = new TreeNode<Integer>(10);
        TreeNode<Integer> node11 = new TreeNode<Integer>(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(widthOfTree(node1));
        System.out.println(maxSumLevelOfTree(node1));
        System.out.println(widthOfTreeRecursion(node1));
    }

    public static int widthOfTree(TreeNode<Integer> root) {
        Queue<TreeNode> queue = new LinkedList();
        int width = 0;
        int count = 0;
        if (root == null) return width;
        queue.add(root);
        width = 1;
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr != null) {
                if (curr.left != null) {
                    queue.add(curr.left);
                    count++;
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    count++;
                }
            } else {
                width = Math.max(width, count);
                count = 0;
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return width;
    }

    public static int maxSumLevelOfTree(TreeNode<Integer> root) {
        Queue<TreeNode> queue = new LinkedList();
        int maxLevelSum = 0;
        int sum = 0;
        if (root == null) return 0;
        queue.add(root);
        maxLevelSum = root.data;
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.remove();
            if (curr != null) {
                if (curr.left != null) {
                    queue.add(curr.left);
                    sum = sum + (Integer) curr.left.data;
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    sum = sum + (Integer) curr.right.data;
                }
            } else {
                maxLevelSum = Math.max(maxLevelSum, sum);
                sum = 0;
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return maxLevelSum;
    }

    public static int widthOfTreeRecursion(TreeNode<Integer> root) {
        int depthOfTree = DepthOfTree.depthOfTree(root);
        int width = 0;
        int tempWidth = 0;
        for (int i = 0; i < depthOfTree; i++) {
            tempWidth = width(root, i);
            width = Math.max(width, tempWidth);
        }
        return width;
    }

    private static int width(TreeNode<Integer> root, int depth) {
        if (root == null) return 0;
        if (depth == 0) return 1;
        return width(root.left,depth-1)+width(root.right,depth-1);
    }
}
