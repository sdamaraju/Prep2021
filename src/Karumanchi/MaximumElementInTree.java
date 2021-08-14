package Karumanchi;

public class MaximumElementInTree {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(12);
        TreeNode<Integer> node3 = new TreeNode<Integer>(31);
        TreeNode<Integer> node4 = new TreeNode<Integer>(41);
        TreeNode<Integer> node5 = new TreeNode<Integer>(15);
        TreeNode<Integer> node6 = new TreeNode<Integer>(16);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        System.out.println(maxElementInTree(node1));
    }

    public static int maxElementInTree(TreeNode<Integer> root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int maxLTree = maxElementInTree(root.left);
        int maxRTree = maxElementInTree(root.right);
        if(maxLTree>= maxRTree && maxLTree>=root.data) return maxLTree;
        if(maxRTree>= maxLTree && maxRTree>=root.data) return maxRTree;
        else return root.data;
    }
}
