package Karumanchi;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfFullNodes {

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
        System.out.println(numberOfFullNodes(node1));
    }

    public static int numberOfFullNodes(TreeNode root) {
        TreeNode cnode = root;
        if(root ==null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            cnode=queue.remove();
            if(cnode.left!=null && cnode.right!=null) {
                count++;
            }
            if(cnode.left!=null) queue.add(cnode.left);
            if(cnode.right!=null) queue.add(cnode.right);
        }
        return count;
    }
}
