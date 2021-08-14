package LeetCodeProblems;


public class InvertBinaryTree {
    public static void main(String[] args) {
        Karumanchi.TreeNode<Integer> node1 = new Karumanchi.TreeNode<Integer>(1);
        Karumanchi.TreeNode<Integer> node2 = new Karumanchi.TreeNode<Integer>(2);
        Karumanchi.TreeNode<Integer> node3 = new Karumanchi.TreeNode<Integer>(3);
        Karumanchi.TreeNode<Integer> node4 = new Karumanchi.TreeNode<Integer>(4);
        Karumanchi.TreeNode<Integer> node5 = new Karumanchi.TreeNode<Integer>(5);
        Karumanchi.TreeNode<Integer> node6 = new Karumanchi.TreeNode<Integer>(6);
        Karumanchi.TreeNode<Integer> node7 = new Karumanchi.TreeNode<Integer>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        invertBinaryTree(node1);
        System.out.println(node1);
        System.out.println(node1.left);
        System.out.println(node1.right);
        System.out.println(node1.left.left);
        System.out.println(node1.left.right);
        System.out.println(node1.right.left);
        System.out.println(node1.right.right);

    }

    private static void invertBinaryTree(Karumanchi.TreeNode<Integer> root) {
        if (root == null) return;
        Karumanchi.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }


}
