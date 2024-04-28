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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        inorder(root1, al1);
        inorder(root2, al2);
        ArrayList<Integer> ans = new ArrayList<>();
        merge(ans, al1, al2);
        return ans;
    }

    public void merge(List<Integer> ans, List<Integer> al1, List<Integer> al2) {
        int i = 0;
        int j = 0;
        int n = al1.size();
        int m = al2.size();
        while (i < n && j < m) {
            if (al1.get(i) < al2.get(j))
                ans.add(al1.get(i++));
            else
                ans.add(al2.get(j++));
        }
        while (i < n)
            ans.add(al1.get(i++));
        while (j < m)
            ans.add(al2.get(j++));

    }

    public void inorder(TreeNode root, ArrayList<Integer> al) {
        if (root != null) {
            inorder(root.left, al);
            al.add(root.val);
            inorder(root.right, al);
        }
    }
}