class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums)
            hs.add(i);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            while (hm.size() == hs.size()) {
                count += n - right;
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0)
                    hm.remove(nums[left]);
                left++;
            }
        }
        return count;
    }
}