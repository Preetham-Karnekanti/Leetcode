class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> order1 = topoSort(rowConditions, k);
        List<Integer> order2 = topoSort(colConditions, k);
        if (order1.size() < k || order2.size() < k)
            return new int[0][0];
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < k; i++)
            m.put(order2.get(i), i);
        int ans[][] = new int[k][k];
        for (int i = 0; i < k; i++)
            ans[i][m.get(order1.get(i))] = order1.get(i);
        return ans;
    }

    public List<Integer> topoSort(int edges[][], int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= k; i++)
            adj.add(new ArrayList<>());
        int indegree[] = new int[k + 1];
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Integer> al = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            al.add(cur);
            for (int ngh : adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        return al;
    }
}