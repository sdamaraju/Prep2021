package Karumanchi;

public class DepthOfTree {
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
        node6.left = node7;
        System.out.println(depthOfTree(node1));
        System.out.println(depthOfTree_Revisit(node1));
    }

    public static int depthOfTree(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int depthLTree = depthOfTree(root.left);
        int depthRTree = depthOfTree(root.right);
        return 1 + (depthLTree > depthRTree ? depthLTree : depthRTree);
    }

    public static int depthOfTree_Revisit(TreeNode<Integer> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = depthOfTree_Revisit(root.left);
        int right = depthOfTree_Revisit(root.right);
        return 1 + Math.max(left,right);
    }
}
