class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int ops = 0;
        for (int value : hm.values()) {
            if (value < 2)
                return -1;
            ops += value / 3;
            if (value % 3 != 0)
                ops++;
        }
        return ops;
    }
}