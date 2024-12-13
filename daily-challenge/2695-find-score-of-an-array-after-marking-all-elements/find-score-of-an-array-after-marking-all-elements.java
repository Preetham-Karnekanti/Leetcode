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
        HashSet<Integer> marked = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (marked.contains(cur[1]))
                continue;
            score += cur[0];
            int idx = cur[1];
            marked.add(cur[1]);
            if (idx - 1 >= 0)
                marked.add(idx - 1);
            if (idx + 1 < nums.length)
                marked.add(idx + 1);
        }
        return score;
    }
}