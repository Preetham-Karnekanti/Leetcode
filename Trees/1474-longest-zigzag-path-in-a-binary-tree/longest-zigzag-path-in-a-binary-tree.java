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
    int maxLen;

    public int longestZigZag(TreeNode root) {
        maxLen = 0;
        helper(root.left, 1, false);
        helper(root.right, 1, true);
        return maxLen;
    }

    public void helper(TreeNode root, int length, boolean isLeft) {
        if (root == null)
            return;
        maxLen = Math.max(maxLen, length);
        if (isLeft) {
            helper(root.left, length + 1, false);
            helper(root.right, 1, true);
        } else {
            helper(root.right, length + 1, true);
            helper(root.left, 1, false);
        }
    }
}

// 1
// 2
// 4
// 5
// 7
// 1
// 3