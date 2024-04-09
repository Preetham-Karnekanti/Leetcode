class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for (int i : nums)
            hs.add(i);
        int right = 0;
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (right < nums.length) {
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            while (hm.size() == hs.size()) {
                count += nums.length - right;
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0) {
                    hm.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return count;
    }
}