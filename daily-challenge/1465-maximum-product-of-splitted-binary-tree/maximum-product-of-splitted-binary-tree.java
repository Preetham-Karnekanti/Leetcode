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
    long ans = Long.MIN_VALUE;
    int mod = (int) 1e9 + 7;

    public int maxProduct(TreeNode root) {
        long totalSum = dfs(root);
        dfs2(root, totalSum);
        return (int) (ans % mod);
    }

    public long dfs(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + dfs(root.left) + dfs(root.right);
    }

    public long dfs2(TreeNode root, long totalSum) {
        if (root == null)
            return 0;
        long leftSum = dfs2(root.left, totalSum);
        long rightSum = dfs2(root.right, totalSum);
        long curSum = leftSum + rightSum + (long) root.val;
        long remaining = totalSum - curSum;
        ans = Math.max(ans, (curSum * remaining));
        return curSum;
    }
}