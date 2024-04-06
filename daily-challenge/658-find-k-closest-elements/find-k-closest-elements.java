class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int i = 0;
        int j = nums.length - 1;
        while (j - i + 1 > k) {
            int l = Math.abs(nums[i] - x);
            int r = Math.abs(nums[j] - x);
            if (l > r)
                i++;
            else
                j--;
        }
        List<Integer> al = new ArrayList<>();
        for (int p = i; p <= j; p++) {
            al.add(nums[p]);
        }
        return al;
    }
}