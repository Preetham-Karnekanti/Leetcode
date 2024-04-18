class Solution {
    public int countTriplets(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int val = nums[i] & nums[j];
                hm.put(val, hm.getOrDefault(val, 0) + 1);
            }
        }
        int cnt = 0;
        for (int a : nums) {
            for (Map.Entry<Integer, Integer> t : hm.entrySet()) {
                if ((t.getKey() & a) == 0)
                    cnt += t.getValue();
            }
        }
        return cnt;
    }
}