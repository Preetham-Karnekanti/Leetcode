class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] topo = new int[n];
        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : prerequisites) {
            indegree[e[0]]++;
            adj.get(e[1]).add(e[0]);
        }
      
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);
        int i = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            topo[i++] = cur;
            for (int ngh : adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        if (i != n)
            return new int[0];
        return topo;
    }
}