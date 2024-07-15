class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {

                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    al.add(l);
                    j++;
                    k--;
                    while (k > j && nums[k] == nums[k + 1])
                        k--;
                } else if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else
                    j++;
            }
        }
        return al;
    }
}