class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums)
            hm.put(num, hm.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        for (Integer i : hm.keySet())
            pq.add(i);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = pq.poll();

        return ans;
    }
}