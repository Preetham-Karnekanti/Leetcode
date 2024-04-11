class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                hm.put(product, hm.getOrDefault(product, 0) + 1);
            }
        }
        int count = 0;
        for (int key : hm.keySet()) {
            int val = hm.get(key);
            count += val * (val-1) * 4;
        }
        return count;
    }
}