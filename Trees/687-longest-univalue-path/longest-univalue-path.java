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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        int ans[] = new int[1];

        helper(root, ans, -1);
        return ans[0] - 1;
    }

    public int helper(TreeNode root, int ans[], int prev) {
        if (root == null)
            return 0;
        int left = helper(root.left, ans, root.val);
        int right = helper(root.right, ans, root.val);
        ans[0] = Math.max(ans[0], left + right + 1);
        return root.val == prev ? Math.max(left, right) + 1 : 0;
    }
}