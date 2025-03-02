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
    int I_NEED_CAMERA = -1;
    int I_AM_COVERED = 1;
    int I_HAVE_CAMERA = 0;
    int camera = 0;

    public int minCameraCover(TreeNode root) {
        camera = 0;
        int ans = helper(root);
        if (ans == I_NEED_CAMERA)
            camera++;
        return camera;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return I_AM_COVERED;
        int lchild = helper(root.left);
        int rchild = helper(root.right);
        if (lchild == I_NEED_CAMERA || rchild == I_NEED_CAMERA) {
            camera++;
            return I_HAVE_CAMERA;
        }
        if (lchild == I_HAVE_CAMERA || rchild == I_HAVE_CAMERA)
            return I_AM_COVERED;
        return I_NEED_CAMERA;
    }
}