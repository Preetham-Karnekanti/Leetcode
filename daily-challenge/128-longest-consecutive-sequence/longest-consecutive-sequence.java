public class Solution {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> nodes = new HashSet<>();

        // Store unique numbers as graph nodes
        for (int num : nums) {
            nodes.add(num);
        }

        Set<Integer> visited = new HashSet<>();
        int maxLength = 0;

        // Start DFS only from the beginning of each sequence
        for (int num : nodes) {
            if (!nodes.contains(num - 1)) {
                int length = dfs(num, nodes, visited);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    private static int dfs(int node, Set<Integer> nodes,
            Set<Integer> visited) {
        if (!nodes.contains(node) || visited.contains(node)) {
            return 0;
        }

        visited.add(node);

        // Follow the directed edge: node -> node + 1
        return 1 + dfs(node + 1, nodes, visited);
    }
}
