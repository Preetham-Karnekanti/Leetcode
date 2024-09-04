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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null)
            return answer;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> nodesAtCurrentLevel = new ArrayList<>();
            int totalNodesAtCurLevel = q.size();
            while (totalNodesAtCurLevel-- > 0) {
                TreeNode cur = q.poll();
                nodesAtCurrentLevel.add(cur.val);
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            answer.add(nodesAtCurrentLevel);
        }
        return answer;
    }
}