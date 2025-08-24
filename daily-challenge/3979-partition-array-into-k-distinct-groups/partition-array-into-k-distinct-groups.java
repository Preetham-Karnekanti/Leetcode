class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0)
            return false;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int groups = n / k;
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
            if (hm.get(i) > groups)
                return false;
        }
        return true;
    }
}