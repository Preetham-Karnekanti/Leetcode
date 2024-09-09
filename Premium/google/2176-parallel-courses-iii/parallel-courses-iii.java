class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int r[] : relations) {
            int u = r[0] - 1;
            int v = r[1] - 1;
            graph.get(u).add(v);
            indegree[v]++;
        }
        int months = 0;
        int maxTime[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                maxTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            int max = 0;
            while (size-- > 0) {
                int cur = q.poll();
                for (int ngh : graph.get(cur)) {
                    maxTime[ngh] = Math.max(maxTime[ngh], maxTime[cur] + time[ngh]);
                    indegree[ngh]--;
                    if (indegree[ngh] == 0) {
                        q.add(ngh);
                    }
                }
            }
        }
        for (int node = 0; node < n; node++) {
            months = Math.max(months, maxTime[node]);
        }
        return months;
    }
}