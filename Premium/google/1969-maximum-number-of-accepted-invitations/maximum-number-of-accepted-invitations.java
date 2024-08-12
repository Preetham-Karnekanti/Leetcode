class Solution {
    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean[] visited = new boolean[n];
            if (helper(i, match, grid, visited)) {
                count++;
            }
        }
        return count;
    }

    private boolean helper(int i, int[] match, int[][] grid, boolean[] visited) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                if (match[j] == -1 || helper(match[j], match, grid, visited)) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}