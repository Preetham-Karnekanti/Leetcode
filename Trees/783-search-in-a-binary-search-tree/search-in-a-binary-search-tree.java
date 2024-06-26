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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val) {
            return root;
        }
        if (val > root.val) {
            TreeNode n = searchBST(root.right, val);
            if (n != null)
                return n;
        }
        if (val < root.val) {
            TreeNode n = searchBST(root.left, val);
            if (n != null)
                return n;
        }
        return null;
    }
}