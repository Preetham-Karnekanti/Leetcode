class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(a, b));
        for (int i : nums) {
            pq.add((long) i);
        }
        int ops = 0;
        while (pq.peek() < k) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a * 2 + b);
            ops++;
        }
        return ops;
    }
}