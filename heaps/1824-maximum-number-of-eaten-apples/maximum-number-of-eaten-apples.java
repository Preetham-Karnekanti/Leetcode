class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int i = 0;
        int ans = 0;
        while (i < apples.length || !pq.isEmpty()) {
            if (i < apples.length && apples[i] != 0) {
                pq.add(new int[] { apples[i], days[i] + i });
            }
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                curr[0]--;
                if (curr[0] > 0) {
                    pq.add(curr);
                }
                ans++;
            }
            i++;
        }

        return ans;

    }
}