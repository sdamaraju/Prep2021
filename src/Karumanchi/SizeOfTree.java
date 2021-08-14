package Karumanchi;

public class SizeOfTree {

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
            node3.left = node6;
            node3.right = node7;
            System.out.println(sizeOfTree(node1));
        }

    static int sizeOfTree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right==null) return 1;

        int left = sizeOfTree(root.left);
        int right = sizeOfTree(root.right);
        return left+right+1;
    }
}
