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

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = getNode(root, x);
        int leftCount = countNode(xNode.left);
        int rightCount = countNode(xNode.right);
        int needed = n / 2 + 1;
        if (leftCount >= needed || rightCount >= needed)
            return true;
        if (leftCount + rightCount + 1 < needed)
            return true;
        return false;
    }

    public TreeNode getNode(TreeNode root, int x) {
        if (root == null)
            return null;
        if (root.val == x)
            return root;
        TreeNode left = getNode(root.left, x);
        if (left != null)
            return left;
        return getNode(root.right, x);
    }

    public int countNode(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}