package Karumanchi;

import java.util.*;

public class LevelOrderTraversalBFS {
    static int diameter = -1;

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
        TreeNode<Integer> node12 = new TreeNode<Integer>(12);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node2.left= node4;
        node4.left=node8;
        node8.left=node9;
        node9.left=node10;
        node10.left=node11;
        node11.left=node12;
        node5.left = node6;
        node6.left= node7;
        // levelOrderTraversal(node1);
        //levelOrderTraversal_revisit(node1);
        //System.out.println(depthOfTree(node1));
        System.out.println(diameterOfTree(node1));

    }

    public static void levelOrderTraversal(TreeNode root) {
        TreeNode cnode = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            cnode = queue.remove();
            System.out.print(cnode);
            if (cnode.left != null) queue.add(cnode.left);
            if (cnode.right != null) queue.add(cnode.right);
        }
    }

    public static void levelOrderTraversal_revisit(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        int levels = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                if (queue.isEmpty()) break;
                levels++;
                queue.add(null);
                continue;
            }
            System.out.println(levels + " " + node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static int depthOfTree(TreeNode root)  {
        if(root != null){
            int lDepth = (root.left != null) ? depthOfTree(root.left) : 0;
            int rDepth = (root.right != null) ? depthOfTree(root.right) : 0;
            return 1 + Math.max(lDepth , rDepth);
        }
        else return 0;
    }

    public static int diameterOfTree(TreeNode root)  {
        if(root != null){
            int lDepth = (root.left != null) ? depthOfTree(root.left) : 0;
            int rDepth = (root.right != null) ? depthOfTree(root.right) : 0;
            int l1 = Math.max(1+lDepth+rDepth, diameter);
            int l2 = Math.max(diameterOfTree(root.left),diameterOfTree(root.right));
            return Math.max(l1,l2);
        }
        else return 0;
    }


}
