class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1)
            return 0;
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean seen[][] = new boolean[n][endingMask];
        for (int i = 0; i < n; i++) {
            q.add(new int[] { i, 1 << i });
            seen[i][1 << i] = true;
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int node = cur[0];
                int mask = cur[1];
                for (int ngh : graph[node]) {
                    int nextMask = mask | (1 << ngh);
                    if (nextMask == endingMask)
                        return 1 + steps;
                    if (seen[ngh][nextMask] == false) {
                        q.add(new int[] { ngh, nextMask });
                        seen[ngh][nextMask] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}