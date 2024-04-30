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
    int freq[];
    int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        freq = new int[10];
        count = 0;
        helper(root);
        return count;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        freq[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPallindrome()) {
                count++;
            }
        }
        helper(root.left);
        helper(root.right);
        freq[root.val]--;
    }

    public boolean isPallindrome() {
        int oddCount = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 == 1)
                oddCount++;
            if (oddCount > 1)
                return false;
        }
        return true;
    }
}