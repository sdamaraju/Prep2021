package Karumanchi;

import java.util.HashSet;
import java.util.Stack;

public class TreeTraversals {

    public static void preOrderTraversalRecursion(TreeNode node) {
        if (node != null) System.out.print(node.data + "-->");
        else return;
        preOrderTraversalRecursion(node.left);
        preOrderTraversalRecursion(node.right);
    }

    public static void inOrderTraversalRecursion(TreeNode node) {
        if (node == null) return;
        inOrderTraversalRecursion(node.left);
        System.out.print(node.data + "-->");
        inOrderTraversalRecursion(node.right);
    }

    public static void postOrderTraversalRecursion(TreeNode node) {
        if (node == null) return;
        postOrderTraversalRecursion(node.left);
        postOrderTraversalRecursion(node.right);
        System.out.print(node.data + "-->");
    }

    public static void preOrderTraversalIterative(TreeNode<Integer> root) {
        Stack<TreeNode> s = new Stack();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            System.out.print(node.data + "-->");
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
        }
    }

    public static void inOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        TreeNode currentNode = root;
        boolean run = true;
        while (run) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (s.isEmpty()) run = false;
                else {
                    currentNode = s.pop();
                    System.out.print(currentNode.data + "-->");
                    currentNode = currentNode.right;
                }
            }
        }

    }

    public static void postOrderTraversalIterativeUsingMemory(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        TreeNode currentNode = root;
        boolean run = true;
        HashSet<TreeNode> set = new HashSet();
        while (run) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (s.isEmpty()) {
                    run = false;
                } else {
                    currentNode = s.peek();
                    if (set.add(currentNode)) {
                        currentNode = currentNode.right;
                    } else {
                        currentNode = s.pop();
                        System.out.print(currentNode.data + "-->");
                        currentNode = null;
                    }
                }
            }
        }
    }
    public static void postOrderTraversalIterativeUsingPointer(TreeNode root) {
        /*TO-DO*/
    }

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
        preOrderTraversalRecursion(node1);
        System.out.println("\n");
        preOrderTraversalIterative(node1);
        System.out.println("\n");
        inOrderTraversalRecursion(node1);
        System.out.println("\n");
        inOrderTraversalIterative(node1);
        System.out.println("\n");
        postOrderTraversalRecursion(node1);
        System.out.println("\n");
        postOrderTraversalIterativeUsingMemory(node1);
    }
}
