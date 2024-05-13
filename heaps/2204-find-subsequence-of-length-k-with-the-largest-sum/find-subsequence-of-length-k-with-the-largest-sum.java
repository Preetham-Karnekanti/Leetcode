class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
            if (pq.size() > k)
                pq.poll();
        }
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        while (!pq.isEmpty()) {
            pq1.add(pq.poll());
        }
        int ans[] = new int[k];
        int i = 0;
        while (!pq1.isEmpty()) {
            ans[i++] = pq1.poll()[0];
        }
        return ans;
    }
}