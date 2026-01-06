/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = Integer.MIN_VALUE;
        int level = 1, ans = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int curSum = 0;
            while (size-- > 0) {
                TreeNode node = q.poll();
                curSum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (curSum > sum) {
                sum = curSum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}