class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int answer = 0;
        int neg = 0;
        int max = -102;
        for (int i : nums) {
            max = Math.max(i, max);
            if (i < 0)
                neg++;
            if (i <= 0 || hs.contains(i))
                continue;
            hs.add(i);
            answer += i;
        }
        return neg == nums.length ? max : answer;
    }
}