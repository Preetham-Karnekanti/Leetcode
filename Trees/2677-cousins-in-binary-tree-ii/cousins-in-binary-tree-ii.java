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
    public TreeNode replaceValueInTree(TreeNode root) {
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, null));
        int curLevelChildSum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int prev = curLevelChildSum;
            curLevelChildSum = 0;
            while (size-- > 0) {
                Pair currNode = q.poll();
                TreeNode curr = currNode.curr;
                TreeNode parent = currNode.parent;
                int childSum = 0;
                if (curr.left != null) {
                    childSum += curr.left.val;
                    q.add(new Pair(curr.left, curr));
                }
                if (curr.right != null) {
                    childSum += curr.right.val;
                    q.add(new Pair(curr.right, curr));
                }
                hm.put(curr, childSum);
                curLevelChildSum += childSum;
                curr.val = prev - hm.getOrDefault(parent, 0); 
            }
        }
        return root;
    }
}

class Pair {
    TreeNode curr;
    TreeNode parent;

    Pair(TreeNode curr, TreeNode parent) {
        this.curr = curr;
        this.parent = parent;
    }
}