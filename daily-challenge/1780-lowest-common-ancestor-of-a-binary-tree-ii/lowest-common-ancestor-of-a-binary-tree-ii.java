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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean hasP = find(root, p);
        boolean hasQ = find(root, q);
        if (hasP == false || hasQ == false)
            return null;
        return helper(root, p, q);
    }

    public boolean find(TreeNode root, TreeNode key) {
        if (root == null)
            return false;
        if (root == key)
            return true;
        return find(root.left, key) || find(root.right, key);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left == null)
            return right;
        if (right == null)
            return left;
        return null;
    }
}