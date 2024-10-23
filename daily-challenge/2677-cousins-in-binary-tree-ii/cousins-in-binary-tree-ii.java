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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int preSum = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            int curSum = 0;
            while (size-- > 0) {
                TreeNode cur = q.poll();
                cur.val = preSum - cur.val;
                int siblingSum = 0;
                if (cur.left != null)
                    siblingSum += cur.left.val;
                if (cur.right != null)
                    siblingSum += cur.right.val;

                if (cur.left != null) {
                    q.add(cur.left);
                    curSum += cur.left.val;
                    cur.left.val = siblingSum;
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    curSum += cur.right.val;
                    cur.right.val = siblingSum;
                }
            }
            preSum = curSum;
        }
        return root;
    }
}