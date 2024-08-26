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
    public TreeNode correctBinaryTree(TreeNode root) {
        HashSet<TreeNode> hs = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        hs.add(root);
        TreeNode incorrect = null;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                    hs.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    if (hs.contains(cur.right)) {
                        incorrect = cur;
                        break;
                    }
                    hs.add(cur.right);
                }
            }
            if (incorrect != null)
                break;
        }
        removeNode(root, incorrect);
        return root;
    }

    public TreeNode removeNode(TreeNode root, TreeNode incorrectNode) {
        if (root == null)
            return null;
        if (root == incorrectNode)
            return null;
        root.left = removeNode(root.left, incorrectNode);
        root.right = removeNode(root.right, incorrectNode);
        return root;
    }
}