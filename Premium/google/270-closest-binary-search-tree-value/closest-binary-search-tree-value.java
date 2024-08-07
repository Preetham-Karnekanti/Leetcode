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
    int ans = Integer.MAX_VALUE;
    double minDiff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return ans;
    }

    public void helper(TreeNode root, double target) {
        if (root == null)
            return;
        double diff = Math.abs(target - root.val);
        if (minDiff > diff) {
            minDiff = diff;
            ans = root.val;
        }
        if (minDiff == diff) {
            ans = Math.min(ans, root.val);
        }
        helper(root.left, target);
        helper(root.right, target);
    }
}