class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : hm.keySet()) {
            if (hm.get(key) > 1)
                continue;
            if (hm.containsKey(key - 1) || hm.containsKey(key + 1))
                continue;
            al.add(key);
        }
        return al;
    }
}