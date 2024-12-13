class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < nums.length; i++)
            pq.add(new int[] { nums[i], i });
        long score = 0;
        boolean marked[] = new boolean[nums.length];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (marked[cur[1]])
                continue;
            score += cur[0];
            int idx = cur[1];
            marked[cur[1]] = true;
            if (idx - 1 >= 0)
                marked[idx - 1] = true;
            if (idx + 1 < nums.length)
                marked[idx + 1] = true;
        }
        return score;
    }
}