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
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        int max[] = new int[1];
        helper(root, max);
        return max[0];
    }

    public int helper(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int curMax = 1;
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (root.left != null && root.val == root.left.val - 1) {
            curMax = Math.max(curMax, 1 + left);
        }
        if (root.right != null && root.val == root.right.val - 1) {
            curMax = Math.max(curMax, 1 + right);
        }
        max[0] = Math.max(max[0], curMax);
        return curMax;
    }
}
