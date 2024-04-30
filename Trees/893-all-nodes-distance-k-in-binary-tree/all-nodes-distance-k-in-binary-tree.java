/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> childToParent = getParents(root);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance++ == k) {
                break;
            }
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.add(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    q.add(cur.right);
                    visited.add(cur.right);
                }
                if (childToParent.containsKey(cur) &&
                        !visited.contains(childToParent.get(cur))) {
                    q.add(childToParent.get(cur));
                    visited.add(childToParent.get(cur));
                }
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        while (!q.isEmpty()) {
            al.add(q.poll().val);
        }
        return al;
    }

    public HashMap<TreeNode, TreeNode> getParents(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                q.add(cur.left);
                hm.put(cur.left, cur);
            }
            if (cur.right != null) {
                q.add(cur.right);
                hm.put(cur.right, cur);
            }
        }

        return hm;
    }
}