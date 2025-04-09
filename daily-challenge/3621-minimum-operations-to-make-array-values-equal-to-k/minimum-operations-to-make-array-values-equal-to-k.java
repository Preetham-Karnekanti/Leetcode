class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) {
            if (i < k)
                return -1;
            if (i == k)
                continue;
            hs.add(i);
        }
        return hs.size();
    }
}