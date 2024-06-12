class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : dislikes) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int colors[] = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1)
                if (bfs(adj, i, colors) == false)
                    return false;
        }
        return true;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int ngh : adj.get(cur)) {
                if (color[ngh] == -1) {
                    color[ngh] = 1 - color[cur];
                    q.add(ngh);
                } else if (color[ngh] == color[cur])
                    return false;
            }
        }
        return true;
    }
}