class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;
        for(int i: nums)
            hs.add(i);
        for (int num : hs) {
            if (!hs.contains(num - 1)) {
                int len = 1;
                int temp = num + 1;
                while(hs.contains(temp)){
                    temp++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}