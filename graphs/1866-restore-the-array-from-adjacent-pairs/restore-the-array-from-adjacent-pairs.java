class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int e[] : adjacentPairs) {
            int u = e[0];
            int v = e[1];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(adj);
        int first = 0;
        for (int key : adj.keySet()) {
            if (adj.get(key).size() == 1) {
                first = key;
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(first, adj, new HashSet<>(), ans);
        int arr[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            arr[i] = ans.get(i);
        return arr;
    }

    public void dfs(int node, HashMap<Integer, ArrayList<Integer>> adj, HashSet<Integer> hs, ArrayList<Integer> ans) {
        ans.add(node);
        hs.add(node);
        for (int ngh : adj.get(node)) {
            if (!hs.contains(ngh)) {
                dfs(ngh, adj, hs, ans);
            }
        }
    }
}