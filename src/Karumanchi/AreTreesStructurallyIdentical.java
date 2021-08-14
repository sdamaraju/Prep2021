package Karumanchi;

public class AreTreesStructurallyIdentical {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node5.left = node6;
        node5.right = node7;
        node6.left = node8;
        System.out.println(areTreesStructurallyIdentical(node1, node5));
    }

    private static boolean areTreesStructurallyIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 == null || node2 == null) return false;
        else {
            return areTreesStructurallyIdentical(node1.left, node2.left) &&
                    areTreesStructurallyIdentical(node1.right, node2.right);
        }
    }
}
