/**
 * Definition for a rope tree node.
 * class RopeTreeNode {
 * int len;
 * String val;
 * RopeTreeNode left;
 * RopeTreeNode right;
 * RopeTreeNode() {}
 * RopeTreeNode(String val) {
 * this.len = 0;
 * this.val = val;
 * }
 * RopeTreeNode(int len) {
 * this.len = len;
 * this.val = "";
 * }
 * RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
 * this.len = len;
 * this.val = "";
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public char getKthCharacter(RopeTreeNode root, int k) {
        return helper(root, k);
    }

    public char helper(RopeTreeNode root, int k) {
        if (root == null)
            return ' ';
        if (root.len == 0) {
            if (root.val.length() >= k)
                return root.val.charAt(k - 1);
        }

        if (root.left != null) {
            RopeTreeNode left = root.left;
            boolean isKOnLeft = left.val.length() >= k || left.len >= k;
            if (isKOnLeft) {
                return helper(left, k);
            }
            int leftCount = left.len + left.val.length();
            return helper(root.right, k - leftCount);
        } else
            return helper(root.right, k);
    }
}