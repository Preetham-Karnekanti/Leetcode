class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = nums2.length-1;
        int res = 0;
        while (i<nums1.length) {
            res += nums1[i++] * nums2[j--];
        }
        return res;
    }
}