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
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).count;
    }

    public Pair helper(TreeNode root) {
        if (root == null)
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        if (left.max < root.val && right.min > root.val) {
            int count = left.count + right.count + 1;
            return new Pair(Math.min(root.val, left.min), Math.max(root.val, right.max), count);
        }
        return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.count, right.count));
    }
}

class Pair {
    int min;
    int max;
    int count;

    Pair(int min, int max, int count) {
        this.min = min;
        this.max = max;
        this.count = count;
    }
}