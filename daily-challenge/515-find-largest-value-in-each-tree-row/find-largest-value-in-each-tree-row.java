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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return answer;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode cur = q.poll();
                max = Math.max(cur.val, max);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null)
                    q.add(cur.right);
            }
            answer.add(max);
        }
        return answer;
    }
}