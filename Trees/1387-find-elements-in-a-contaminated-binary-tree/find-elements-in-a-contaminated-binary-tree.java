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
class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        root.val = 0;
        recover(root);
    }

    public void recover(TreeNode tempRoot) {
        if (tempRoot == null)
            return;
        if (tempRoot.left != null)
            tempRoot.left.val = 2 * tempRoot.val + 1;
        if (tempRoot.right != null)
            tempRoot.right.val = 2 * tempRoot.val + 2;
        recover(tempRoot.left);
        recover(tempRoot.right);
    }

    public boolean find(int target) {
        TreeNode temp = root;
        return find(temp, target);
    }

    public boolean find(TreeNode temp, int target) {
        if (temp == null)
            return false;
        if (temp.val == target)
            return true;
        return find(temp.left, target) || find(temp.right, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */