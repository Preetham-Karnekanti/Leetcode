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
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return ans;
    }

    public void helper(TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return;
        if (sum == root.val && root.left == null && root.right == null) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        sum -= root.val;
        path.add(root.val);
        helper(root.left, sum, path);
        helper(root.right, sum, path);
        path.remove(path.size() - 1);
    }
}