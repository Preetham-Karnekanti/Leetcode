class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = pid.size();
        for (int i = 0; i < n; i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);
            if (parent == 0)
                continue;
            adj.putIfAbsent(parent, new ArrayList<>());
            adj.get(parent).add(child);
        }
        List<Integer> answer = new ArrayList<>();
        dfs(answer, kill, adj);
        return answer;
    }

    public void dfs(List<Integer> answer, int node, HashMap<Integer, ArrayList<Integer>> adj) {
        answer.add(node);
        for (int ngh : adj.getOrDefault(node, new ArrayList<>())) {
            dfs(answer, ngh, adj);
        }
    }
}