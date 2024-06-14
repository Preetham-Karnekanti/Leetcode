class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int ans[] = new int[n];
        Arrays.fill(ans, (int) 1e9);
        ans[0] = 0;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int node = cur[1];
            int time = cur[0];
            if (ans[node] != -1 && time > ans[node])
                continue;
            for (Pair ngh : adj.get(node)) {
                int adjNode = ngh.node;
                int curTime = ngh.wt;
                if (curTime + time < disappear[adjNode]) {
                    if (curTime + time < ans[adjNode]) {
                        ans[adjNode] = curTime + time;
                        q.add(new int[] { curTime + time, adjNode });
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == (int) 1e9)
                ans[i] = -1;
        }
        return ans;
    }
}

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}