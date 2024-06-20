class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0)
                len = Math.max(len, i + 1);
            else if (hm.containsKey(sum)) {
                len = Math.max(len, i - hm.get(sum));
            }
            hm.putIfAbsent(sum, i);
        }
        return len;
    }
}