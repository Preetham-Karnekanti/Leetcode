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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int max = root.val;
        int ans = 1;
        int level = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level++;
            while (size-- > 0) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            if (sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}