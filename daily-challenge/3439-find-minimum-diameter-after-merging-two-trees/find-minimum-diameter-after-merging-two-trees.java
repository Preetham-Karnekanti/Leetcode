class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        ArrayList<ArrayList<Integer>> tree1 = buildTree(n, edges1);
        ArrayList<ArrayList<Integer>> tree2 = buildTree(m, edges2);

        int diameter1 = findDiameter(n, tree1);
        int diameter2 = findDiameter(m, tree2);

        int combined = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;
        return Math.max(diameter1, Math.max(diameter2, combined));
    }

    private ArrayList<ArrayList<Integer>> buildTree(int size, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    private int findDiameter(int n, ArrayList<ArrayList<Integer>> tree) {
        Pair p1 = bfs(n, tree, 0);
        int farthestNode = p1.node;

        Pair second = bfs(n, tree, farthestNode);
        return second.distance;
    }

    private Pair bfs(int n, ArrayList<ArrayList<Integer>> tree, int src) {
        Queue<Integer> q = new LinkedList<>();

        int distance[] = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int ngh : tree.get(cur)) {
                int newDistance = distance[cur] + 1;
                if (distance[ngh] > newDistance) {
                    distance[ngh] = newDistance;
                    q.add(ngh);
                }
            }
        }
        int maxDistance = 0;
        int node = src;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                node = i;
            }
        }

        return new Pair(node, maxDistance);
    }
}

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}