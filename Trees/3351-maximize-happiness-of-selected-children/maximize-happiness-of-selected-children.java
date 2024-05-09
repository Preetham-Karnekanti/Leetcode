class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : happiness) {
            pq.add(i);
        }
        int count = 0;
        while (k-- > 0) {
            if (pq.peek() - count >= 0) {
                ans += pq.poll() - count;
            }
            count++;
        }
        return ans;
    }
}