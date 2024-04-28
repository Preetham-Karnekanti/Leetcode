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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int low, int high) {
        if (low > high)
            return null;
        int maxIdx = findMax(nums, low, high);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = construct(nums, low, maxIdx - 1);
        root.right = construct(nums, maxIdx + 1, high);
        return root;
    }

    public int findMax(int nums[], int low, int high) {
        int maxIdx = low;
        int max = nums[low];
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                maxIdx = i;
                max = nums[i];
            }
        }
        return maxIdx;
    }
}