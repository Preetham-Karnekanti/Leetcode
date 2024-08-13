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
    public List<Integer> getLonelyNodes(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        helper(root, al);
        return al;
    }

    public void helper(TreeNode root, ArrayList<Integer> al) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null && root.right != null) {
            helper(root.left, al);
            helper(root.right, al);
        } else if (root.left == null) {
            al.add(root.right.val);
            helper(root.right, al);
        } else if (root.right == null) {
            al.add(root.left.val);
            helper(root.left, al);
        }
    }
}