class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums)
            pq.add(i);
        int i = 0;
        while (!pq.isEmpty()) {
            int one = pq.poll();
            int two = pq.poll();
            nums[i++] = two;
            nums[i++] = one;
        }

        return nums;
    }
}