class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[] = new int[n];
        for (int e[] : edges) {
            indegree[e[1]]++;
        }
        int count = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                count++;
                node = i;
            }
        }
        if (node == -1 || count > 1)
            return -1;

        return node;

    }
}