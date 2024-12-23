/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean foundP, foundQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helper(root, p, q);
        if (foundP && foundQ)
            return res;
        return null;
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (root == p) {
            foundP = true;
            return root;
        }
        if (root == q) {
            foundQ = true;
            return root;
        }
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}