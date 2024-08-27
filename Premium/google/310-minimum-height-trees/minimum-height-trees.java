class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++)
                ans.add(i);
            return ans;
        }
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        int[] deg = new int[n];
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            deg[e[0]]++;
            deg[e[1]]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1)
                q.add(i);
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= q.size();
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int ngh : adj.get(cur)) {
                    deg[ngh]--;
                    if (deg[ngh] == 1)
                        q.add(ngh);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }
}