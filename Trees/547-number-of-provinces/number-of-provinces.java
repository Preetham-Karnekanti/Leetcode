class Solution {
    int n;
    boolean visited[];

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int count = 0;
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(isConnected, i);
                count++;
            }
        }
        return count;
    }

    public void bfs(int[][] grid, int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < grid[cur - 1].length; i++) {
                if (grid[cur - 1][i] == 1 && !visited[i + 1]) {
                    q.add(i + 1);
                    visited[i + 1] = true;
                }
            }
        }
    }
}