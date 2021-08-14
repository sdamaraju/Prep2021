package Karumanchi;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    static int recurseAns=-1;
    static int height = -1;

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
        node7.right=node5;


        System.out.println(findBottomLeftTreeValue(node1));
        System.out.println(findBottomLeftTree_recurse(node1,1));
        System.out.println(findBottomRightTree_recurse(node1,1));
        System.out.print(findBottomLeftTree_recurse1(node1,1));
    }

    private static int findBottomLeftTreeValue(TreeNode<Integer> root) {
        int bottomLeftTreeValue = root.data;
        boolean set = true;
        Queue queue = new LinkedList();
        queue.add(root);
        queue.add("#");
        while (!queue.isEmpty()) {
            if (queue.peek() == "#") {
                queue.remove();
                if(queue.isEmpty()) return bottomLeftTreeValue;
                queue.add("#");
                set = true;
                continue;
            }
            TreeNode<Integer> node = (TreeNode) queue.remove();
            if (node.left != null) {
                queue.add(node.left);
                if(set){
                    bottomLeftTreeValue = (int) node.left.data;
                    set = false;
                }
            }
            if (node.right != null){
                queue.add(node.right);
                if(set){
                    bottomLeftTreeValue = (int) node.right.data;
                    set = false;
                }
            }
        }
        return bottomLeftTreeValue;
    }

    private static int findBottomLeftTree_recurse(TreeNode root, int level){
        if (root== null) return -1;
        if(level > height) {
            recurseAns = (int)root.data;
            height = level;
        }
        findBottomLeftTree_recurse(root.left,level+1);
        findBottomLeftTree_recurse(root.right,level+1);
        return recurseAns;
    }

    private static int findBottomRightTree_recurse(TreeNode root, int level){
        if (root== null) return -1;
        if(level >= height) {
            recurseAns = (int)root.data;
            height = level;
        }
        findBottomLeftTree_recurse(root.left,level+1);
        findBottomLeftTree_recurse(root.right,level+1);
        return recurseAns;
    }

    private static int findBottomLeftTree_recurse1(TreeNode root, int level){
        if (root == null) return -1;
        if(level > height){
            height = level;
            recurseAns = (int) root.data;
        }
        findBottomLeftTree_recurse(root.left,level+1);
        findBottomLeftTree_recurse(root.right,level+1);
        return recurseAns;
    }
}
