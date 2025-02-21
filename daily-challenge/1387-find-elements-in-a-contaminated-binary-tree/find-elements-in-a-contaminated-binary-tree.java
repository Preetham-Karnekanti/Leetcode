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
    HashSet<Integer> hs;
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        hs = new HashSet<>();
        recover(this.root, 0);
    }

    public void recover(TreeNode root, int value) {
        if (root == null)
            return;
        root.val = value;
        hs.add(root.val);
        recover(root.left, 2 * value + 1);
        recover(root.right, 2 * value + 2);
    }

    public boolean find(int target) {
        return hs.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */