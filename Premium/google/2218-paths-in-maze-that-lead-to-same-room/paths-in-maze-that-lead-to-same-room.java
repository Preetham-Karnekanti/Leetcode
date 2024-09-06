class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        int count = 0;
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<=n;i++)
            graph.add(new HashSet<>());
        for(int c[] : corridors){
            int u = c[0];
            int v = c[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i = 1;i<=n;i++){
            for(int ngh : graph.get(i)){
                for(int ngh2 : graph.get(ngh)){
                    if(graph.get(ngh2).contains(i))
                        count++;
                }
            }
        }
        return count/6;
    }
}