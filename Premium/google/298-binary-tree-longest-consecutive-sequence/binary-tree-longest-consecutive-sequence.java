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
        helper(root, null, max, 0);
        return max[0];
    }

    public void helper(TreeNode root, TreeNode parent, int[] max, int length) {
        if (root == null)
            return;
        length = (parent != null && parent.val == root.val - 1) ? length + 1 : 1;
        max[0] = Math.max(max[0], length);
        helper(root.left, root, max, length);
        helper(root.right, root, max, length);
    }
}
