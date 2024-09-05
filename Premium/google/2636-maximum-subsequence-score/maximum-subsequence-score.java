class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = new int[] { nums1[i], nums2[i] };
        }

        Arrays.sort(res, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            sum += res[i][0];
            pq.add(res[i][0]);
        }
        ans = Math.max(ans, sum * res[k - 1][1]);
        for (int i = k; i < n; i++) {
            sum += res[i][0] - pq.poll();
            pq.add(res[i][0]);
            ans = Math.max(ans, sum * res[i][1]);
        }
        return ans;
    }
}