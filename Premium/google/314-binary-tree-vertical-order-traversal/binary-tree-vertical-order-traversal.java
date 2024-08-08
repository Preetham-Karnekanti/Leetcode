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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        q.add(new Node(root, 0, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            TreeNode node = cur.node;
            int row = cur.row;
            int col = cur.col;
            max = Math.max(max, col);
            min = Math.min(min, col);
            hm.putIfAbsent(col, new ArrayList<>());
            hm.get(col).add(node.val);
            if (node.left != null) {
                int nr = row + 1;
                int nc = col - 1;
                q.add(new Node(node.left, nr, nc));
            }
            if (node.right != null) {
                int nr = row + 1;
                int nc = col + 1;
                q.add(new Node(node.right, nr, nc));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = min; i <= max; i++)
            ans.add(hm.get(i));
        return ans;
    }
}

class Node {
    TreeNode node;
    int row;
    int col;

    Node(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}