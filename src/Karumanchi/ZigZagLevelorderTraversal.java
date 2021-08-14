package Karumanchi;

import Karumanchi.TreeNode;

import java.util.*;

public class ZigZagLevelorderTraversal {
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
        node4.left = node6;
        node4.right = node7;
        //zigzagLevelOrderTraversal(node1);
        /*System.out.println(zigzagLevelOrderTraversal_(node1));*/
        System.out.println(zigzagLevelOrderTraversalBetterVersion(node1));

    }

    private static List<List<Integer>> zigzagLevelOrderTraversal_(TreeNode<Integer> root) {
        ArrayList resultList = new ArrayList();
        ArrayList levelList = new ArrayList();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        boolean isZigzag = true;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr != null) {
                levelList.add(curr);
            }
            if (curr == null) {
                System.out.println(levelList);
                if (isZigzag) {
                    resultList.add(levelList);
                    isZigzag = !isZigzag;
                } else {
                    ArrayList reverseList = new ArrayList();
                    for (int i = levelList.size() - 1; i >= 0; i--) reverseList.add(levelList.get(i));
                    resultList.add(reverseList);
                    isZigzag = !isZigzag;
                }
                if (queue.isEmpty()) return resultList;
                queue.add(null);
                levelList = new ArrayList();
                continue;
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return resultList;
    }

    private static List<List<Integer>> zigzagLevelOrderTraversalBetterVersion(TreeNode<Integer> root) {
        ArrayList resultList = new ArrayList();
        Deque levelList = new LinkedList();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        boolean isZigzag = true;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr != null) {
                if(isZigzag) levelList.addLast(curr);
                else levelList.addFirst(curr);
            }
            if (curr == null) {
                resultList.add(levelList);
                isZigzag = !isZigzag;
                if (queue.isEmpty()) return resultList;
                queue.add(null);
                levelList = new LinkedList();
                continue;
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return resultList;
    }


}
