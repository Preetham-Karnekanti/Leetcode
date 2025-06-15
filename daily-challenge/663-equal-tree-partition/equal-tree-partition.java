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
    private Map<Integer, Integer> subTreeTotal = new HashMap<>();

    public boolean checkEqualTree(TreeNode root) {
        int total = getTotal(root);

        if (total % 2 != 0)
            return false;

        if (total == 0)
            return subTreeTotal.get(0) > 1;

        return subTreeTotal.containsKey(total / 2);
    }

    private int getTotal(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = getTotal(root.left);
        int rightSum = getTotal(root.right);

        int currSum = leftSum + rightSum + root.val;

        subTreeTotal.put(currSum, subTreeTotal.getOrDefault(currSum, 0) + 1);

        return currSum;
    }
}