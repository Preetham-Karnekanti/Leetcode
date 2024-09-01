class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashMap<Integer, ArrayList<Pair>> graph = new HashMap<>();
        for (int i = 0; i < meetings.length; i++) {
            int x = meetings[i][0];
            int y = meetings[i][1];
            int time = meetings[i][2];
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            graph.get(x).add(new Pair(time, y));
            graph.get(y).add(new Pair(time, x));
        }

        int timeTaken[] = new int[n];
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        timeTaken[0] = 0;
        timeTaken[firstPerson] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        q.add(new int[] { firstPerson, 0 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int node = cur[0];
            int timeTakenSoFar = cur[1];
            for (Pair ngh : graph.getOrDefault(node, new ArrayList<>())) {
                int time = ngh.time;
                int adjNode = ngh.node;
                if (timeTakenSoFar <= time && timeTaken[adjNode] > time) {
                    timeTaken[adjNode] = time;
                    q.add(new int[] { adjNode, time });
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (timeTaken[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}

class Pair {
    int time;
    int node;

    Pair(int time, int node) {
        this.time = time;
        this.node = node;
    }
}