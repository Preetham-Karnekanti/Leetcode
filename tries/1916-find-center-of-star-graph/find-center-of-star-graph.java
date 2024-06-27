class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int degree[] = new int[n + 2];
        for (int e[] : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
        }
        for (int i = 0; i < degree.length; i++)
            if (degree[i] == n)
                return i;
        return 0;
    }
}