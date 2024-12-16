class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        for (int i = 0; i < nums.length; i++)
            pq.add(new int[] { nums[i], i });
        while (k-- > 0) {
            int cur[] = pq.poll();
            int index = cur[1];
            nums[index] = multiplier * cur[0];
            pq.add(new int[] { nums[index], index });
        }
        return nums;
    }
}