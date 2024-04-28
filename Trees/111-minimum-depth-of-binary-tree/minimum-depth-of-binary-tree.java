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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lh = 1 + minDepth(root.left);
        int rh = 1 + minDepth(root.right);
        if (root.left == null)
            return rh;
        else if (root.right == null)
            return lh;
        return Math.min(lh, rh);
    }
}