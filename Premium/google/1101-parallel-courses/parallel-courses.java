class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n + 1];
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : relations) {
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int size = q.size();
        int count = 0;
        int steps = 0;
        while (size != 0) {
            steps++;
            while (size-- > 0) {
                count++;
                int cur = q.poll();
                for (int ngh : adj.get(cur)) {
                    indegree[ngh]--;
                    if (indegree[ngh] == 0) {
                        q.add(ngh);
                    }
                }
            }
            size = q.size();
        }
        return count == n ? steps : -1;
    }
}