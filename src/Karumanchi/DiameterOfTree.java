package Karumanchi;

public class DiameterOfTree {

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
        node4.left=node9;
        node9.right=node10;
        node10.left=node11;
        node5.right=node6;
        node6.left=node8;
        node8.right=node7;
        System.out.println(diameterOfTree(node1));
    }

    public static int depthOfTree(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int depthLTree = depthOfTree(root.left);
        int depthRTree = depthOfTree(root.right);
        return 1 + (depthLTree > depthRTree ? depthLTree : depthRTree);
    }

    private static int diameterOfTree(TreeNode node){
        if (node == null) {
            return 0;
        }
    int ltreeDepth = depthOfTree(node.left);
    int rtreeDepth = depthOfTree(node.right);
    int l1 = 1+ltreeDepth+rtreeDepth;
    int l2= Math.max(diameterOfTree(node.left),diameterOfTree(node.right));
    return Math.max(l1,l2);
    }

}
