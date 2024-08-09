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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        if (isLeaf(root))
            return ans;
        List<Integer> leftNodes = new ArrayList<>();
        addLeftNodes(leftNodes, root.left);
        List<Integer> rightNodes = new ArrayList<>();
        addRightNodes(rightNodes, root.right);
        List<Integer> leaves = new ArrayList<>();
        addLeafNodes(leaves, root);
        ans.addAll(leftNodes);
        ans.addAll(leaves);
        Collections.reverse(rightNodes);
        ans.addAll(rightNodes);
        return ans;
    }

    public void addLeftNodes(List<Integer> al, TreeNode root) {
        if (root == null)
            return;
        if (isLeaf(root) == false)
            al.add(root.val);
        if (root.left != null)
            addLeftNodes(al, root.left);
        else
            addLeftNodes(al, root.right);
    }

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    public void addRightNodes(List<Integer> al, TreeNode root) {
        if (root == null)
            return;
        if (isLeaf(root) == false)
            al.add(root.val);
        if (root.right != null)
            addRightNodes(al, root.right);
        else
            addRightNodes(al, root.left);
    }

    public void addLeafNodes(List<Integer> al, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            al.add(root.val);
        addLeafNodes(al, root.left);
        addLeafNodes(al, root.right);
    }
}