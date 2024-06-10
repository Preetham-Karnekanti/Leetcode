class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int degree[] = new int[n];
        boolean graph[][] = new boolean[n][n];
        for (int e[] : roads) {
            degree[e[0]]++;
            degree[e[1]]++;
            graph[e[0]][e[1]] = true;
            graph[e[1]][e[0]] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++){
                int temp = degree[i] + degree[j];
                if(graph[i][j] || graph[j][i])
                    temp--;
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}