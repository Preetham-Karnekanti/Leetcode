class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for (int i : nums)
            hs.add(i);
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> h1 = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                h1.add(nums[j]);
                if (h1.size() == hs.size())
                    count++;
            }
            System.out.println();

        }
        return count;
    }
}