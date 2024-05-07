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
    int max;

    public int maxSumBST(TreeNode root) {
        max = 0;
        helper(root);
        return Math.max(max, 0);
    }

    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if (left.maxNode < root.val && root.val < right.minNode) {
            max = Math.max(left.sum + right.sum + root.val, max);
            return new Pair(Math.min(left.minNode, root.val), Math.max(right.maxNode, root.val), left.sum + right.sum + root.val);
        }
        return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
}

class Pair {
    int maxNode, minNode, sum;

    Pair(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}