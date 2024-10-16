class Solution {
    public int[][] highFive(int[][] items) {
        int minId = Integer.MAX_VALUE;
        int maxId = Integer.MIN_VALUE;
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for (int i[] : items) {
            int id = i[0];
            int mark = i[1];
            minId = Math.min(minId, id);
            maxId = Math.max(maxId, id);
            hm.putIfAbsent(id, new PriorityQueue<>());
            hm.get(id).add(mark);
            if (hm.get(id).size() > 5)
                hm.get(id).poll();
        }
        int ans[][] = new int[hm.size()][2];
        int idx = 0;
        for (int i = minId; i <= maxId; i++) {
            if (hm.get(i) != null) {
                PriorityQueue<Integer> pq = hm.get(i);
                int sum = 0;
                while (!pq.isEmpty()) {
                    sum += pq.poll();
                }
                ans[idx++] = new int[] { i, sum / 5 };
            }
        }
        return ans;
    }
}