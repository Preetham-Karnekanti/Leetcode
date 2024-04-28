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

    int arr[][] = new int[2][2];

    public void helper(TreeNode root, int level, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.val == x || root.right != null && root.right.val == x) {
            arr[0][0] = root.val;
            arr[0][1] = level + 1;
        }
        if (root.left != null && root.left.val == y || root.right != null && root.right.val == y) {
            arr[1][0] = root.val;
            arr[1][1] = level + 1;
        }
        helper(root.left, level + 1, x, y);
        helper(root.right, level + 1, x, y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        helper(root, 0, x, y);
        return (arr[0][0] != arr[1][0] && arr[0][1] == arr[1][1]);
    }
}
