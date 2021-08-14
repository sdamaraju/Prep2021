package LeetCodeProblems;

public class DeepestNodeSum {

    public static void main(String[] args) {
        DeepestNodeSum run = new DeepestNodeSum();
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, new TreeNode(6, null, null)));
        System.out.println(tree);
        int deepestLevel = run.findHeightOfTree(tree);
        System.out.println(deepestLevel);
        System.out.println(run.calculateDeepestNodeSum(tree, 1, deepestLevel));
    }

    private int findHeightOfTree(TreeNode tree) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return 1;
        return 1 + Math.max(findHeightOfTree(tree.left),findHeightOfTree(tree.right));
    }

    private int calculateDeepestNodeSum(TreeNode tree, int currLevel, int deepestLevel) {
        if(currLevel < deepestLevel){
            int leftSum = 0; int rightSum = 0;
            if(tree.left != null){
               leftSum = calculateDeepestNodeSum(tree.left , currLevel+1, deepestLevel);
            }
            if(tree.right != null){
                rightSum = calculateDeepestNodeSum(tree.right , currLevel+1, deepestLevel);
            }
            return leftSum + rightSum;
        }
        else return tree.val;
    }

    // try this in one pass..


}
