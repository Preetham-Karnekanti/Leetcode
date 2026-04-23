class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] res = new long[n];
        for (List<Integer> group : groups.values()) {
            long total = 0;
            for (int idx : group) {
                total += idx;
            }
            long prefixTotal = 0;
            int sz = group.size();
            for (int i = 0; i < sz; i++) {
                int idx = group.get(i);
                long leftSum = (long)idx * (long)i - prefixTotal;
                long rightSum = total - prefixTotal - (long)idx - (long)idx*(sz - i - 1);
                res[idx] =  rightSum + leftSum;
                prefixTotal += idx;
            }
        }
        return res;
    }
}