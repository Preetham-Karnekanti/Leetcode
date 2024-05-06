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

    public boolean hasSum(TreeNode node, int k, TreeNode root) {
        if (node == null)
            return false;
        int target = k - node.val;
        if (find(node, target, root))
            return true;
        return hasSum(node.left, k, root) || hasSum(node.right, k, root);
    }

    public boolean find(TreeNode node, int target, TreeNode root) {
        if (root == null)
            return false;
        if (root.val == target && root != node)
            return true;
        if (root.val > target)
            return find(node, target, root.left);
        return find(node, target, root.right);
    }
}