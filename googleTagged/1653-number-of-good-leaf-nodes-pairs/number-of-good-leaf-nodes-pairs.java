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
    int count;

    public int countPairs(TreeNode root, int distance) {
        count = 0;
        helper(root, distance);
        return count;
    }

    public ArrayList<Integer> helper(TreeNode root, int d) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> left = helper(root.left, d);
        ArrayList<Integer> right = helper(root.right, d);
        if (left.size() == 0 && right.size() == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            return temp;
        }
        for (int i : left) {
            for (int j : right) {
                if (i + j <= d)
                    count++;
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : left) {
            temp.add(i + 1);
        }
        for (int i : right) {
            temp.add(i + 1);
        }
        return temp;
    }
}