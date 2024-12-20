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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, ArrayList<TreeNode>> levelWiseNodes = new HashMap<>();
        int level = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                levelWiseNodes.putIfAbsent(level, new ArrayList<>());
                levelWiseNodes.get(level).add(cur);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            level++;
        }
        for (int curLevel = 1; curLevel < levelWiseNodes.size(); curLevel += 2) {
            ArrayList<TreeNode> curLevelNodes = levelWiseNodes.getOrDefault(curLevel, new ArrayList<>());
            int i = 0;
            int j = curLevelNodes.size() - 1;
            while (i < j) {
                int temp = curLevelNodes.get(i).val;
                curLevelNodes.get(i).val = curLevelNodes.get(j).val;
                curLevelNodes.get(j).val = temp;
                i++;
                j--;
            }
        }
        return root;
    }
}