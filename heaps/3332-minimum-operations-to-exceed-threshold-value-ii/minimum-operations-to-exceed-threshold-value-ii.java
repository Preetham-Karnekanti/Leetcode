class Solution {
    public int minOperations(int[] nums, int k) {
        int ops = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++)
            pq.add((long) nums[i]);
        while (pq.size() > 1 && pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            long val = Math.min(x, y) * 2 + Math.max(x, y);
            if (val < (long) k) {
                pq.add(val);
            }
            ops++;
        }
        if (pq.size() > 0 && pq.peek() < k)
            ops++;
        return ops;
    }
}