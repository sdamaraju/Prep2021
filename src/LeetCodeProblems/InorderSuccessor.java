package LeetCodeProblems;

public class InorderSuccessor {
    static boolean ret = false;
    static TreeNode op = null;
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, new TreeNode(6, null, null)));
        //inorderTraversal(tree, new TreeNode(2,null,null));
        //TreeNode target = inorderTraversal1(tree, new TreeNode(2,null,null), false, null);
        //System.out.println(target);
        //System.out.println(op);
    }

    private static void inorderTraversal(TreeNode tree, TreeNode p) {
        if(tree.left != null) {
            inorderTraversal(tree.left, p);
        }
        if(ret){
            op = tree;
            ret = false;
        }
        System.out.println(tree.val);
        if(tree.equals(p)) {
            ret = true;
        }
        if(tree.right != null){
            inorderTraversal(tree.right, p);
        }

    }

    /*private static TreeNode inorderTraversal1(TreeNode tree, TreeNode p, boolean stop, TreeNode target) {
        if(tree.left != null) {
            inorderTraversal1(tree.left, p, stop, target);
        }
        if(stop == true){
            target = tree;
        }
        System.out.println(tree.val);
        if(tree.equals(p)) {
            stop = true;
        }
        if(tree.right != null){
            inorderTraversal1(tree.right, p, stop, target);
        }
        return target;
    }*/


}
