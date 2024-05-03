public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0L));
        while (!q.isEmpty()) {
            int size = q.size();
            long mini = q.peek().getValue();
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                long curr = q.peek().getValue();
                TreeNode node = q.poll().getKey();
                if (i == 0)
                    first = curr;
                if (i == size - 1)
                    last = curr;
                if (node.left != null)
                    q.offer(new Pair<>(node.left, curr * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair<>(node.right, curr * 2 + 2));
            }
            ans = Math.max(ans, (int) (last - first + 1));
        }
        return ans;
    }
}