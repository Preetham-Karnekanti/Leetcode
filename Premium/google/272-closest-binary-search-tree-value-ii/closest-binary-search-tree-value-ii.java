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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.diff, a.diff));
        helper(root, target, k, pq);
        ArrayList<Integer> al = new ArrayList<>();
        while (!pq.isEmpty()) {
            al.add(pq.poll().value);
        }
        return al;
    }

    public void helper(TreeNode root, double target, int k, PriorityQueue<Pair> pq) {
        if (root == null)
            return;
        double diff = Math.abs(target - root.val);
        pq.add(new Pair(root.val, diff));
        if (pq.size() > k)
            pq.poll();
        helper(root.left, target, k, pq);
        helper(root.right, target, k, pq);
    }
}

class Pair {
    int value;
    double diff;

    Pair(int value, double diff) {
        this.value = value;
        this.diff = diff;
    }
}