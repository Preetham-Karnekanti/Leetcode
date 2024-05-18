class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < nums1.length; i++)
            pq.add(new int[] { nums1[i] + nums2[0], 0 });
        while (k-- > 0 && !pq.isEmpty()) {
            int cur[] = pq.poll();
            int sum = cur[0];
            int idx = cur[1];
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(sum - nums2[idx]);
            temp.add(nums2[idx]);
            ans.add(temp);
            if (idx + 1 < nums2.length) {
                pq.add(new int[] {
                        sum - nums2[idx] + nums2[idx + 1],
                        idx + 1
                });
            }
        }
        return ans;
    }
}