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
    public int minCameraCover(TreeNode root) {
        Map<TreeNode, Map<Integer, Integer>> dp = new HashMap<>();
        int result = dfs(root, 0, dp);
        return result;
    }

    private int dfs(TreeNode node, Integer state, Map<TreeNode, Map<Integer, Integer>> dp) {

        if (node == null)
            return 0;

        if (dp.containsKey(node) && dp.get(node).containsKey(state))
            return dp.get(node).get(state);

        int result = 0;

        // For recursion to maintain the valid state transitions, each and every node
        // needs to be covered
        // So, when node is not monitored, we either place camera at the node or one of
        // its children
        if (state == 0) {
            int camsWithCameraOnThisNode = 1 + dfs(node.left, 1, dp) + dfs(node.right, 1, dp);

            int camsWithCameraOnLeftChild = Integer.MAX_VALUE;
            if (node.left != null) {
                camsWithCameraOnLeftChild = dfs(node.left, 2, dp) + dfs(node.right, 0, dp);
            }

            int camsWithCameraOnRightChild = Integer.MAX_VALUE;
            if (node.right != null) {
                camsWithCameraOnRightChild = dfs(node.left, 0, dp) + dfs(node.right, 2, dp);
            }

            result = Math.min(Math.min(camsWithCameraOnThisNode, camsWithCameraOnLeftChild),
                    camsWithCameraOnRightChild);
            dp.computeIfAbsent(node, n -> new HashMap<>()).put(state, result);
        } else if (state == 1) {
            // When node is already monitored, we can either place camera here to monitor
            // its children or not place it and let above case, with state == 0, take its
            // course
            int camsWithCameraOnThisNode = 1 + dfs(node.left, 1, dp) + dfs(node.right, 1, dp);
            int camsWithoutCameraOnThisNode = dfs(node.left, 0, dp) + dfs(node.right, 0, dp);

            result = Math.min(camsWithCameraOnThisNode, camsWithoutCameraOnThisNode);
            dp.computeIfAbsent(node, n -> new HashMap<>()).put(state, result);
        } else {
            // When node has a camera, there's no other option than children getting
            // monitored
            result = 1 + dfs(node.left, 1, dp) + dfs(node.right, 1, dp);
            dp.computeIfAbsent(node, n -> new HashMap<>()).put(state, result);
        }
        return result;
    }
}