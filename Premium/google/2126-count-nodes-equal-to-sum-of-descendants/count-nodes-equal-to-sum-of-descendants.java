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
    public int equalToDescendants(TreeNode root) {
        int count[] = new int[1];
        helper(root, count);
        return count[0];
    }

    public long helper(TreeNode root, int[] count) {
        if (root == null)
            return 0;
        long left = helper(root.left, count);
        long right = helper(root.right, count);
        if (left + right == root.val)
            count[0]++;
        return left + right + root.val;
    }
}