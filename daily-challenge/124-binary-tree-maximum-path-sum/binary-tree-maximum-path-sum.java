/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int lsum = Math.max(0, helper(root.left));
        int rsum = Math.max(0, helper(root.right));
        ans = Math.max(ans, lsum + rsum + root.val);
        return Math.max(lsum, rsum) + root.val;
    }
}