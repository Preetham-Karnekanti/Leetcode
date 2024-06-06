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
        return max;
    }

    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if (root.val > left.max && root.val < right.min) {
            max = Math.max(left.sum + right.sum + root.val, max);
            return new Pair(Math.min(left.min, root.val), Math.max(right.max, root.val),
                    left.sum + right.sum + root.val);
        }
        return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
}

class Pair {
    int min;
    int max;
    int sum;

    Pair(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}