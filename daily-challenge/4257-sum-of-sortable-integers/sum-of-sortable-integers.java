class Solution {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        List<Integer> fac = new ArrayList<>();

        for (int x = 1; x * x <= n; x++) {
            if (n % x == 0) {
                fac.add(x);
                if (n / x != x) {
                    fac.add(n / x);
                }
            }
        }

        int[] target = nums.clone();
        Arrays.sort(target);

        int ans = 0;

        for (int d : fac) {
            boolean allGood = true;
            for (int left = 0; left < n; left += d) {
                int right = left + d - 1;

                int[] sub1 = Arrays.copyOfRange(nums, left, right + 1);
                int[] sub2 = Arrays.copyOfRange(target, left, right + 1);

                if (!check(sub1, sub2)) {
                    allGood = false;
                    break;
                }
            }
            if (allGood) {
                ans += d;
            }
        }

        return ans;
    }

    private boolean check(int[] nums1, int[] nums2) {
        int L = nums1.length;
        int pivot = -1;

        for (int i = 0; i < L - 1; i++) {
            if (nums1[i] > nums1[i + 1]) {
                if (pivot != -1) {
                    return false;
                }
                pivot = i + 1;
            }
        }

        if (pivot == -1) {
            return Arrays.equals(nums1, nums2);
        }

        for (int i = 0; i < L; i++) {
            if (nums1[(pivot + i) % L] != nums2[i]) {
                return false;
            }
        }

        return true;
    }
}