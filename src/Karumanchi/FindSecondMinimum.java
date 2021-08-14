package Karumanchi;

public class FindSecondMinimum {
    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(2);
        TreeNode<Integer> node5 = new TreeNode<Integer>(4);
        TreeNode<Integer> node6 = new TreeNode<Integer>(3);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(findSecondMinimum(node1, Integer.MAX_VALUE, node1.data));
    }

    public static int findSecondMinimum(TreeNode<Integer> root, int smin, int min) {
        int sLmin = Integer.MAX_VALUE, sRmin = Integer.MAX_VALUE;
        if (root != null) {
            if (root.data > min && root.data < smin) {
                smin = root.data;
                return smin;
            }
        }
        if (root.left != null) sLmin = findSecondMinimum(root.left, smin, min);
        if (root.right != null) sRmin = findSecondMinimum(root.right, smin, min);
        return Math.min(sLmin,sRmin);
    }

}
