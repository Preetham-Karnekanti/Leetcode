class Solution {
    public int findShortestSubArray(int[] nums) {
        int maxSize = 0;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.putIfAbsent(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxSize < hm.get(nums[i]).size()) {
                maxSize = hm.get(nums[i]).size();
            }
        }
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> v = hm.get(nums[i]);
            if (v.size() == maxSize) {
                ans = Math.min(ans, v.get(v.size() - 1) - v.get(0) + 1);
            }
        }
        return ans;
    }
}