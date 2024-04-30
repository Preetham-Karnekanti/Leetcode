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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        al.add(val);
        return construct(al, 0, al.size() - 1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null)
            return;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }

    public TreeNode construct(ArrayList<Integer> al, int start, int end) {
        if (start > end)
            return null;
        int maxIdx = findMax(al, start, end);
        TreeNode root = new TreeNode(al.get(maxIdx));
        root.left = construct(al, start, maxIdx - 1);
        root.right = construct(al, maxIdx + 1, end);
        return root;
    }

    public int findMax(ArrayList<Integer> al, int start, int end) {
        int idx = start;
        int max = al.get(start);
        for (int i = start; i <= end; i++) {
            if (al.get(i) > max) {
                max = al.get(i);
                idx = i;
            }
        }
        return idx;
    }
}