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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        helper(root, val, 1, depth);
        return root;
    }

    public void helper(TreeNode root, int val, int d, int depth) {
        if (root == null) {
            return;
        }
        if (d == depth - 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            root.left = newLeft;
            root.right = newRight;
            newLeft.left = left;
            newRight.right = right;
            return;
        }
        helper(root.left, val, d + 1, depth);
        helper(root.right, val, d + 1, depth);
    }
}