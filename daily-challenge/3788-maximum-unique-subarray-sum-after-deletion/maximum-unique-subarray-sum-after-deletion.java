class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int answer = 0;
        int nge = 0;
        int max = -102;
        for (int i : nums) {
            max = Math.max(i, max);
            if (i < 0)
                nge++;
            if (i <= 0 || hs.contains(i))
                continue;
            hs.add(i);
            answer += i;
        }
        return nge == nums.length ? max : answer;
    }
}