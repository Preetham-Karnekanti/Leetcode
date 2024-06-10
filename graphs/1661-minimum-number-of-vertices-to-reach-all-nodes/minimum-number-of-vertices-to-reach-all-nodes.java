class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        int degree[] = new int[n];
        for (List<Integer> e : edges) {
            degree[e.get(1)]++;
        }
        for (int i = 0; i < n; i++)
            if (degree[i] == 0)
                ans.add(i);
        return ans;
    }
}