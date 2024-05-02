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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        ArrayList<Integer> al = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        inorder(root, al);
        for (int i = 0; i < queries.size(); i++) {
            int value = queries.get(i);
            res.add(new ArrayList<>());
            int ans1 = findMin(al, value);
            int ans2 = findMax(al, value);
            res.get(i).add(ans1);
            res.get(i).add(ans2);
        }
        return res;
    }

    public int findMin(ArrayList<Integer> al, int target) {
        int low = 0;
        int high = al.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (al.get(mid) > target) {
                high = mid - 1;
            } else {
                ans = al.get(mid);
                low = mid + 1;
            }
        }
        return ans;
    }

    public int findMax(ArrayList<Integer> al, int target) {
        int low = 0;
        int high = al.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (al.get(mid) < target)
                low = mid + 1;
            else {
                ans = al.get(mid);
                high = mid - 1;
            }
        }
        return ans;
    }

    public void inorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null)
            return;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
}