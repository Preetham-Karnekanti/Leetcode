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
    public boolean findTarget(TreeNode root, int k) {
        return hasSum(root, k, root);
    }

    public boolean hasSum(TreeNode root, int k, TreeNode node) {
        if (node == null)
            return false;
        int target = k - node.val;
        boolean isFound = findNode(root, target, node);
        if (isFound)
            return true;
        return hasSum(root, k, node.left) || hasSum(root, k, node.right);
    }

    public boolean findNode(TreeNode root, int k, TreeNode node) {
        if (root == null)
            return false;
        if (root.val == k && root != node)
            return true;
        if (root.val > k)
            return findNode(root.left, k, node);
        return findNode(root.right, k, node);
    }
}