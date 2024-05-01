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
    List<List<Integer>> al;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        al = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return al;
    }

    public void helper(TreeNode root, int targetSum, List<Integer> temp) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && root.val == targetSum) {
            temp.add(root.val);
            al.add(new ArrayList<>(temp));
        } else {
            temp.add(root.val);
            helper(root.left, targetSum - root.val, temp);
            helper(root.right, targetSum - root.val, temp);
        }
        temp.remove(temp.size() - 1);
    }
}