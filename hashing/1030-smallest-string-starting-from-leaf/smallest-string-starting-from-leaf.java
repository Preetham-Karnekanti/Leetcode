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
    public String smallestFromLeaf(TreeNode root) {
        return helper(root, "");
    }

    public String helper(TreeNode root, String temp) {
        if (root == null)
            return temp;
        temp = (char) (root.val + 'a') + temp;
        if (root.left == null && root.right == null)
            return temp;

        String left = root.left != null ? helper(root.left, temp) : null;
        String right = root.right != null ? helper(root.right, temp) : null;

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return left.compareTo(right) < 0 ? left : right;
    }
}