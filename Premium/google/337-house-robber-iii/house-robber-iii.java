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
    HashMap<TreeNode, Integer> hm;

    public int rob(TreeNode root) {
        hm = new HashMap<>();
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        if(hm.containsKey(root))
            return hm.get(root);
        int take = root.val
                + (root.left == null ? 0
                        : helper(root.left.left) + helper(root.left.right))
                + (root.right == null ? 0 : helper(root.right.right) + helper(root.right.left));
        int notTake = helper(root.left) + helper(root.right);
        hm.put(root, Math.max(take,notTake));
        return Math.max(take, notTake);
    }
}