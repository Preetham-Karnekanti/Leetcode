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
    HashMap<Integer, Integer> hm;
    int maxFreq = -1;

    public int[] findFrequentTreeSum(TreeNode root) {
        hm = new HashMap<>();
        helper(root);
        ArrayList<Integer> al = new ArrayList<>();
        for (int key : hm.keySet()) {
            if (hm.get(key) == maxFreq)
                al.add(key);
        }
        int arr[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
            arr[i] = al.get(i);

        return arr;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val + helper(root.left) + helper(root.right);
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        int freq = hm.get(sum);
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        return sum;
    }
}