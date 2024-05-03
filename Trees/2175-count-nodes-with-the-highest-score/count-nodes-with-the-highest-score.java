class Solution {
    long maxScore = 0;

    public int countHighestScoreNodes(int[] parents) {
        HashMap<Integer, Node> hm = new HashMap<>();
        maxScore = -1;
        for (int i = 0; i < parents.length; i++) {
            hm.put(i, new Node(i));
        }
        for (int i = 1; i < parents.length; i++) {
            Node parent = hm.get(parents[i]);
            if (parent.left == null)
                parent.left = hm.get(i);
            else
                parent.right = hm.get(i);
        }
        int totalNodes = parents.length;
        HashMap<Long, Integer> count = new HashMap<>();
        helper(hm.get(0), count, totalNodes);
        System.out.println(count);
        return count.get(maxScore);
    }

    public long helper(Node root, HashMap<Long, Integer> count, int totalNodes) {
        if (root == null)
            return 0;
        long leftCount = helper(root.left, count, totalNodes);
        long rightCount = helper(root.right, count, totalNodes);
        long total = 1 + leftCount + rightCount;
        long remaining = totalNodes - total;
        long score = Math.max(1, remaining) * Math.max(1, leftCount) * Math.max(1, rightCount);
        maxScore = Math.max(maxScore, score);
        count.put(score, count.getOrDefault(score, 0) + 1);
        return total;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}