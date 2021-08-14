package Karumanchi;

import java.util.Objects;

public class TreeNode<E> {
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public E data;

    TreeNode(TreeNode left, TreeNode right, E data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public TreeNode(E data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(data, treeNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return  data + " next -->" +next ;
    }
}
