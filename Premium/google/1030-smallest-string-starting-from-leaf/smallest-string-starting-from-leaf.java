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
        String left = helper(root.left, temp);
        String right = helper(root.right, temp);
        if (root.left == null)
            return right;
        if (root.right == null)
            return left;
        return left.compareTo(right) < 0 ? left : right;
    }
}