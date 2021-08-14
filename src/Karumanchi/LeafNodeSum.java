package Karumanchi;

public class LeafNodeSum {
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
        System.out.println(leafNodeSum(node1));
        System.out.println(leftleafSum(node1,true));
    }

    private static int leafNodeSum(TreeNode<Integer> root) {
        if (root ==null) return 0;
        if(root.left == null && root.right==null) return root.data;
        int leftSum = leafNodeSum(root.left);
        int rightSum = leafNodeSum(root.right);
        return leftSum+rightSum;
    }

    private static int leftleafSum(TreeNode<Integer> root, boolean value) {
        // sum of all leaves which are left to parents
        if (root == null) return 0;
        if(root.left == null && root.right==null && value) return root.data;
        else if (root.left == null && root.right==null) return 0;
        int leftSum = leftleafSum(root.left ,true);
        int rightSum = leftleafSum(root.right,false);
        return leftSum+rightSum;
    }

    private static int leftLeafSum(TreeNode root, boolean consider){
        if(root == null) return 0;
        if(root.left == null && root.right ==null && consider){
            return (int)root.data;
        }
        int leftSum = leftleafSum(root.left, true);
        int rightSum = leftleafSum(root.right, false);
        return leftSum + rightSum;

    }

    // same thing can be achieved using level order traversal.
}
