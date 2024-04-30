/**
 * 
 * [3],[20,9],[10,20,15,7],[18,45,10,16,45,23,12,16]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode n = q.poll();
                temp.add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(temp);
            }
            al.add(temp);
            level++;
        }

        return al;
    }
}