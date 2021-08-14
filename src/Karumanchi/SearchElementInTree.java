package Karumanchi;

public class SearchElementInTree {
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
        System.out.println(searchElementInTree(node1,42));
    }

    public static boolean searchElementInTree(TreeNode<Integer> root, int searchEle) {
        if(root == null){
            return false;
        } else if (root.data == searchEle){
            return true;
        } else {
            boolean foundL = searchElementInTree(root.left, searchEle);
            boolean foundR = searchElementInTree(root.right, searchEle);
            return foundL || foundR;
        }
    }

}
