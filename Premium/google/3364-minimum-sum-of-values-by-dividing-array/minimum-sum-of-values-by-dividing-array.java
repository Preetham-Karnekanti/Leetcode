class Solution {
    public int minimumValueSum(int[] nums, int[] andValues) {
        HashMap<String, Integer> hm = new HashMap<>();
        int ans = helper(nums, andValues, 0, 0, -1, hm);
        return ans == (int) 1e9 ? -1 : ans;
    }

    public int helper(int nums[], int andValues[], int i, int j, int andSoFar, HashMap<String, Integer> hm) {
        if (i == nums.length && j == andValues.length)
            return 0;
        if (i == nums.length || j == andValues.length)
            return (int) 1e9;
        String key = i + ":" + j + ":" + andSoFar;
        if (hm.containsKey(key))
            return hm.get(key);
        int curAnd = andSoFar & nums[i];
        int one = (int) 1e9;
        if (curAnd == andValues[j])
            one = nums[i] + helper(nums, andValues, i + 1, j + 1, -1, hm);
        int two = helper(nums, andValues, i + 1, j, curAnd, hm);
        hm.put(key, Math.min(one, two));
        return Math.min(one, two);
    }
}