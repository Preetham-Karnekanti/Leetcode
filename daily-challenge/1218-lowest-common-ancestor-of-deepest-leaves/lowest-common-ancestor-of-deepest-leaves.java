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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).getKey();
    }

    public Pair<TreeNode, Integer> helper(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }
        Pair<TreeNode, Integer> left = helper(root.left);
        Pair<TreeNode, Integer> right = helper(root.right);
        if (left.getValue() == right.getValue()) {
            return new Pair<>(root, left.getValue() + 1);
        }
        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        return new Pair<>(right.getKey(), right.getValue() + 1);
    }
}