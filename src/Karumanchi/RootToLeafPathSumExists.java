package Karumanchi;

public class RootToLeafPathSumExists {
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
        node4.left = node6;
        node4.right = node7;
        node7.left = node5;
        node3.right=node5;
        System.out.println(rootToLeafPathSumExists(node1, 70));
    }

    private static boolean rootToLeafPathSumExists(TreeNode<Integer> root, int sum) {
        return rootToLeafPathSumExists(root,0,sum);
    }

    private static boolean rootToLeafPathSumExists(TreeNode<Integer> root, int currSum, int sum) {
        if (root == null) return false;
        if (root.data + currSum == sum && root.left==null && root.right==null) return true;
        if (root.left==null && root.right==null) return false;
        return rootToLeafPathSumExists(root.left, root.data + currSum, sum) || rootToLeafPathSumExists(root.right, root.data+ currSum, sum);
    }


}
