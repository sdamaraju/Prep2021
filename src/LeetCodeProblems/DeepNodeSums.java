package LeetCodeProblems;

public class DeepNodeSums {
    static int sum = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), new TreeNode(5, new TreeNode(18,new TreeNode(1,null,null),null), null));
        deepNodeSum(node, 1, heightofTree(node));
        System.out.println(sum);
    }

    private static void deepNodeSum(TreeNode node, int currLevel, int level) {
        if(node == null) return;
        if (currLevel == level) {
            sum = sum + node.val;
            return;
        }
        else {
            deepNodeSum(node.left,currLevel+1,level);
            deepNodeSum(node.right,currLevel+1,level);
        }
    }

    private static int heightofTree(TreeNode node) {
        if (node == null) return 0;
        int lTree = heightofTree(node.left);
        int rTree = heightofTree(node.right);
        return 1 + Math.max(lTree, rTree);
    }


}
