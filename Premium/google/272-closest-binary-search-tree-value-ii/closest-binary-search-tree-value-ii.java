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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            double diff1 = Math.abs(target - a);
            double diff2 = Math.abs(target - b);
            return Double.compare(diff2, diff1);
        });
        helper(root, target, k, pq);
        ArrayList<Integer> al = new ArrayList<>();
        while (!pq.isEmpty()) {
            al.add(pq.poll());
        }
        return al;
    }

    public void helper(TreeNode root, double target, int k, PriorityQueue<Integer> pq) {
        if (root == null)
            return;
        double diff = Math.abs(target - root.val);
        pq.add(root.val);
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