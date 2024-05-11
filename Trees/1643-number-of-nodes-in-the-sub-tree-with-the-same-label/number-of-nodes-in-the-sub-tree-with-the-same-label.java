class Solution {
    int result[];

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        result = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i[] : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        dfs(0, adj, new boolean[n], labels);
        return result;
    }

    public int[] dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis, String labels) {
        vis[start] = true;
        int count[] = new int[26];
        for (int ngh : adj.get(start)) {
            if (!vis[ngh]) {
                int childCount[] = dfs(ngh, adj, vis, labels);
                for (int i = 0; i < 26; i++) {
                    count[i] += childCount[i];
                }
            }
        }
        count[labels.charAt(start) - 'a']++;
        result[start] = count[labels.charAt(start) - 'a'];
        return count;
    }
}