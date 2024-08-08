class Pair {
    long sum;
    int index;

    public Pair(long sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}

class Solution {
    int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (Pair a, Pair b) -> Long.compare(a.sum, b.sum));
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums[i], i + 1));
        }

        int res = 0;
        for (int i = 1; i <= right; i++) {
            Pair p = pq.remove();
            if (i >= left) {
                res = (int) ((p.sum + res) % MOD);
            }
            if (p.index < n) {
                p.sum += nums[p.index++];

                pq.offer(p);
            }
        }
        return res;
    }
}