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
    int minDifference = Integer.MAX_VALUE;
    TreeNode prevNode = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDifference;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prevNode != null) {
            minDifference = Math.min(minDifference, root.val - prevNode.val);
        }
        prevNode = root;
        inorder(root.right);
    }
}