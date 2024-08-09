class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n + 1];
        for (List<Integer> sequence : sequences) {
            for (int i = 0; i < sequence.size() - 1; i++) {
                int u = sequence.get(i);
                int v = sequence.get(i + 1);
                if (u < 0 || v < 0 || u > n || v > n)
                    return false;
                adj.get(u).add(v);
                indegree[v]++;
            }
        }
        int[] topo = new int[n];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            if (q.size() > 1)
                return false;
            int cur = q.poll();
            topo[idx++] = cur;
            for (int ngh : adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        return Arrays.equals(topo, nums);
    }
}