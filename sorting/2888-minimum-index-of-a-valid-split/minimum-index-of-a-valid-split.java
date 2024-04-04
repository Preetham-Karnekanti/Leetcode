class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int dominant = -1;
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
            if (hm.get(i) * 2 > nums.size())
                dominant = i;
        }
        int maxCount = hm.get(dominant);
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) {
                count++;
                maxCount--;
            }
            if (count * 2 > (i + 1) && maxCount * 2 > (n - i - 1))
                return i;
        }
        return -1;
    }
}