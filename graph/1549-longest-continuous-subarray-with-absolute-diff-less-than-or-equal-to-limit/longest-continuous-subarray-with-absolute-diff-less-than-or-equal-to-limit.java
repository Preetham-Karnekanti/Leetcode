class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0, ans = 0, n = nums.length;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);

        for (; r < n; r++) {
            maxHeap.add(r);
            minHeap.add(r);

            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && nums[maxHeap.peek()] - nums[minHeap.peek()] > limit) {
                while (l >= minHeap.peek()) {
                    minHeap.poll();
                }

                while (l >= maxHeap.peek()) {
                    maxHeap.poll();
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}