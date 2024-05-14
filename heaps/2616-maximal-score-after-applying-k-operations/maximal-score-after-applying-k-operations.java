class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums)
            pq.add(i);
        while (k-- > 0) {
            int cur = pq.poll();
            ans += cur;
            int val = cur % 3 == 0 ? cur / 3 : 1 + cur / 3;
            pq.add(val);
        }
        return ans;
    }
}