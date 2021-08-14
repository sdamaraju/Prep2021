package Karumanchi;

import java.util.*;

public class WidthOFTreeRevisit {
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
        node4.left = node6;
        node4.right = node7;
        node7.left = node5;


        System.out.println(widthOfTree(node1));
        levelOrderAverage(node1);
        //System.out.println(maxSumLevelOfTree(node1));
        // System.out.println(widthOfTreeRecursion(node1));
        HashMap map = new HashMap();
        levelOrderAverageRecurrsion(node1, 1, map);
        Set<Map.Entry> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            int sum = 0;
            ArrayList list = (ArrayList) entry.getValue();
            for (int i = 0; i < list.size(); i++) sum = sum + (int) list.get(i);
            System.out.println("For level " + entry.getKey() + " , the average is "+sum/list.size());
        }
    }

    private static int widthOfTree(TreeNode<Integer> root) {
        if(root.left == null && root.right==null) return 1;
        Queue queue = new LinkedList();
        queue.add(root);
        queue.add("#");
        int maxWidth=0;
        int width = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() == "#") {
                if(width > maxWidth) maxWidth = width;
                width = 0;
                queue.remove();
                if(queue.isEmpty()) return maxWidth;
                queue.add("#");
                continue;
            }
            TreeNode node = (TreeNode) queue.remove();
            if (node.left != null) {
                queue.add(node.left);
                width++;
            }
            if (node.right != null){
                queue.add(node.right);
                width++;
            }
        }
        return maxWidth;
    }

    private static void levelOrderAverage(TreeNode<Integer> root) {
        Queue queue = new LinkedList();
        queue.add(root);
        queue.add("#");
        int sum=0;
        int nodesPerLevel = 0;
        int level=0;
        while (!queue.isEmpty()) {
            if (queue.peek() == "#") {
                level++;
                System.out.println("At level "+level+ " , the average of nodes is "+ sum/nodesPerLevel);
                sum=0;
                nodesPerLevel=0;
                queue.remove();
                if(queue.isEmpty()) return;
                queue.add("#");
                continue;
            }
            TreeNode<Integer> node = (TreeNode) queue.remove();
            nodesPerLevel++;
            sum= sum + node.data;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void levelOrderAverageRecurrsion(TreeNode root, int currentLevel, HashMap<Integer, ArrayList> map) {
        if (root == null) return;
        if (map.get(currentLevel) == null) {
            ArrayList valuesInLevel = new ArrayList<Integer>();
            valuesInLevel.add(root.data);
            map.put(currentLevel, valuesInLevel);
        } else {
            ArrayList valuesInLevel = map.get(currentLevel);
            valuesInLevel.add(root.data);
        }
        if (root.left != null) levelOrderAverageRecurrsion(root.left, currentLevel + 1, map);
        if (root.right != null) levelOrderAverageRecurrsion(root.right, currentLevel + 1, map);
    }



}
