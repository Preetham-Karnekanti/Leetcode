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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int p = findParent(descriptions);
        TreeNode root = new TreeNode(p);
        System.out.println(root.val);
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        hm.put(p, root);
        for (int i = 0; i < descriptions.length; i++) {
            int parentVal = descriptions[i][0];
            int childVal = descriptions[i][1];
            boolean isLeft = descriptions[i][2] == 1 ? true : false;
            TreeNode parent = hm.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = hm.getOrDefault(childVal, new TreeNode(childVal));
            if (isLeft)
                parent.left = child;
            else
                parent.right = child;
            hm.putIfAbsent(parentVal, parent);
            hm.putIfAbsent(childVal, child);
        }
        return root;
    }

    public int findParent(int[][] descriptions) {
        HashSet<Integer> childs = new HashSet<>();
        for (int desc[] : descriptions) {
            childs.add(desc[1]);
        }
        for (int desc[] : descriptions) {
            if (!childs.contains(desc[0]))
                return desc[0];
        }
        return -1;
    }
}