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
    public double maximumAverageSubtree(TreeNode root) {
        double max[] = new double[1];
        helper(root, max);
        return max[0];
    }

    public Result helper(TreeNode root, double[] max) {
        if (root == null)
            return new Result(0, 0);
        Result left = helper(root.left, max);
        Result right = helper(root.right, max);
        double sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;
        max[0] = Math.max(max[0], sum/count);
        return new Result(count, sum);
    }
}

class Result {
    int count;
    double sum;

    Result(int count, double sum) {
        this.count = count;
        this.sum = sum;
    }
}