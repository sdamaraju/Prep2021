package Karumanchi;

public class SearchInTree {
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
        System.out.println(searchInTree(node1, 161, false));
    }

    private static boolean searchInTree(TreeNode<Integer> root, int value, boolean found) {
        if (root == null) return false;
        if (root.data == value) {
            return true;
        }
        if (root.left == null && root.right == null) return false;
        boolean foundInLeftTree = searchInTree(root.left,value,false);
        if(foundInLeftTree) return true;
        return searchInTree(root.right,value,false);
    }

}
