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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Pair>> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        Pair temp = new Pair(root, 0, 0);
        q.add(temp);
        hm.put(0, new PriorityQueue<>());
        hm.get(0).add(temp);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.node.left != null) {
                int nextRow = p.row + 1;
                int nextCol = p.col - 1;
                Pair left = new Pair(p.node.left, nextRow, nextCol);
                hm.putIfAbsent(nextCol, new PriorityQueue<>());
                hm.get(nextCol).add(left);
                q.add(left);
            }
            if (p.node.right != null) {
                int nextRow = p.row + 1;
                int nextCol = p.col + 1;
                Pair right = new Pair(p.node.right, nextRow, nextCol);
                hm.putIfAbsent(nextCol, new PriorityQueue<>());
                hm.get(nextCol).add(right);
                q.add(right);
            }
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int key : hm.keySet()) {
            PriorityQueue<Pair> pq = hm.get(key);
            ArrayList<Integer> al = new ArrayList<>();
            while (!pq.isEmpty())
                al.add(pq.poll().node.val);
            ans.add(al);
        }
        return ans;
    }
}

class Pair implements Comparable<Pair> {
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }

    public int compareTo(Pair p) {
        if (col != p.col)
            return col - p.col;
        if (row != p.row)
            return row - p.row;
        return node.val - p.node.val;
    }
}

// [[2],[0],[1,3,5,34],[3,2,2],[4,4,6,6],[1]] expected
// [[2],[0],[1,3,5,34],[2,2,3],[4,4,6,6],[1]]