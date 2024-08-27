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
    public int findDistance(TreeNode root, int p, int q) {
        if (p == q)
            return 0;
        TreeNode lca = findLca(root, p, q);
        int distanceToP = findDistance(lca, p);
        int distanceToQ = findDistance(lca, q);
        return distanceToP + distanceToQ;
    }

    public TreeNode findLca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        return root;
    }

    public int findDistance(TreeNode root, int p) {
        if (root == null)
            return (int) 1e8;
        if (root.val == p)
            return 0;
        int left = findDistance(root.left, p) + 1;
        int right = findDistance(root.right, p) + 1;
        return Math.min(left, right);
    }
}