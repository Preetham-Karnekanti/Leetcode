class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int ngh : adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}