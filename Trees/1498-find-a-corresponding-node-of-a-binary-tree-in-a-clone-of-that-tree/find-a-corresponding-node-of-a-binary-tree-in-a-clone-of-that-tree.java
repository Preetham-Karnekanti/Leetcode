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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(cloned, target);
    }

    public TreeNode helper(TreeNode root, TreeNode target) {
        if (root == null)
            return null;
        if (root.val == target.val) {
            return root;
        }
        TreeNode n = helper(root.left, target);
        if (n != null)
            return n;
        TreeNode n1 = helper(root.right, target);
        if (n1 != null)
            return n1;
        return null;
    }
}