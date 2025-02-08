class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        long sum = 0;
        int ops = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            sum += nums[i];
            if (sum < 0) {
                sum -= pq.poll();
                ops++;
            }
        }
        return ops;
    }
}