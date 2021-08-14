package Karumanchi.StillNotDone;

import Karumanchi.TreeNode;

public class SizeOfCompleteBinaryTree {
    int size = 0;

    public static void main(String[] args) {

    }

    public int sizeOfCBT(TreeNode root) {
        TreeNode rootCopy = root;
        if (root == null) return 0;
        int levels = 1;
        while (root.left != null) {
            root = root.left;
            levels++;
        }
        int sizeTillPenultimateLevel = ((2 ^ (levels - 1)) - 1);
        int lastLevelNodeCount = getLastLevelCount(rootCopy,levels);
        return sizeTillPenultimateLevel + lastLevelNodeCount;
    }

    private int getLastLevelCount(TreeNode root, int levels) {
        boolean exists = evaluateIfLastLevelExists(root.right,levels,2);
        if(exists) return getLastLevelCount(root.right,levels);
        else {
            exists = evaluateIfLastLevelExists(root.left.right,levels,2);
            if(exists) return getLastLevelCount(root.right,levels);
        }
        return -1;
    }

    public void recursive(TreeNode root,int depth){
        /*int left = travelLeft(root.left);
        int right = travelLeft(root.right);
        if(left == right) recursive(root.right,depth-1);
        else recursive(root.left,depth-1);*/
    }

    private boolean evaluateIfLastLevelExists(TreeNode root, int levels, int currentLevel) {
        if(root == null) return false;
        while (currentLevel <= levels) {
            root = root.left;
            currentLevel++;
        }
        if(currentLevel == levels) return true;
        else return false;
    }



}
