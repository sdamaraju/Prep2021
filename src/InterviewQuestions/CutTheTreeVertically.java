package InterviewQuestions;

import Karumanchi.TreeNode;

import java.util.*;

public class CutTheTreeVertically {
    private static HashMap map = new HashMap();
    private static int minLevel = Integer.MAX_VALUE;
    private static int maxLevel = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new Karumanchi.TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new Karumanchi.TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new Karumanchi.TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new Karumanchi.TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new Karumanchi.TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new Karumanchi.TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new Karumanchi.TreeNode<Integer>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        cutTreeVertically(node1, 0);
        List<List<Integer>> results = new ArrayList();
        for(int i=minLevel;i<=maxLevel;i++){
            results.add((List)map.get(i));
        }

    }

    private static void cutTreeVertically(TreeNode<Integer> root, int hLevel) {
        if(root == null) return ;
        ArrayList nodes = (ArrayList)map.get(hLevel);
        minLevel = Math.min(minLevel,hLevel);
        maxLevel = Math.max(maxLevel,hLevel);
        if(nodes == null) {
            nodes = new ArrayList();
            nodes.add(root.data);
            map.put(hLevel,nodes);
        } else nodes.add(root.data);
        cutTreeVertically(root.left, hLevel-1);
        cutTreeVertically(root.right, hLevel+1);
        int intervals1[] = new int []{1,2};
        int intervals2[] = new int []{2,3};
        int intervals[][] = new int [][]{intervals1,intervals2};
    }

}
