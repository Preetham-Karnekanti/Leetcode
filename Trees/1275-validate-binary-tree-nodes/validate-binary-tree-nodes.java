class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = -1;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < leftChild.length; i++) {
            hs.add(leftChild[i]);
            hs.add(rightChild[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!hs.contains(i)) {
                if (root == -1)
                    root = i;
                else
                    return false;
            }
        }
        if (root == -1)
            return false;

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(root);
        vis.add(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (leftChild[cur] != -1) {
                if (vis.contains(leftChild[cur]))
                    return false;
                q.add(leftChild[cur]);
                vis.add(leftChild[cur]);
            }
            if (rightChild[cur] != -1) {
                if (vis.contains(rightChild[cur]))
                    return false;
                q.add(rightChild[cur]);
                vis.add(rightChild[cur]);
            }
        }
        return vis.size() == n;
    }
}