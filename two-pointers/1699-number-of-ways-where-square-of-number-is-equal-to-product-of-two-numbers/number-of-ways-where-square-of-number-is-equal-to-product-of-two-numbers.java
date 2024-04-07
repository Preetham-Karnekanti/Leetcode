class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return (int)countWays(nums1, nums2) + (int)countWays(nums2, nums1);
    }

    public long countWays(int[] nums1, int[] nums2) {
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            int k = nums2.length - 1;
            long square = (long)nums1[i] * (long)nums1[i];
            while (j < k) {
                long product = (long) nums2[j] * (long) nums2[k];
                if (square == product) {
                    if (nums2[j] == nums2[k]) {
                        int q = k - j + 1;
                        count = count + (q * (q - 1)) / 2;
                        break;
                    }
                    int jNew = j;
                    int kNew = k;

                    while (nums2[j] == nums2[jNew])
                        jNew++;
                    while (nums2[k] == nums2[kNew])
                        kNew--;
                    count += (jNew - j) * (k - kNew);
                    j = jNew;
                    k = kNew;
                } else if (square > product)
                    j++;
                else
                    k--;
            }
        }
        return count;
    }
}