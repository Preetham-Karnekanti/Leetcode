/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("n ");
                continue;
            }
            q.add(cur.left);
            q.add(cur.right);
            sb.append(cur.val + " ");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String tree[] = data.split(" ");
        if (tree[0].equals("n"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < tree.length; i++) {
            TreeNode cur = q.poll();
            if (!tree[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(tree[i]));
                cur.left = left;
                q.add(left);
            }
            i++;
            if (!tree[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(tree[i]));
                cur.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));