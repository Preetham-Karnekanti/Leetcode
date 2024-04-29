/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int diff = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        preorder(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return diff;
    }

    public void preorder(TreeNode root, int min, int max) {
        if (root == null)
            return;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff = Math.max(diff, max - min);
        preorder(root.left, min, max);
        preorder(root.right, min, max);
    }
}