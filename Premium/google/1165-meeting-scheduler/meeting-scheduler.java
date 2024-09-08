class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

        int left = 0, right = 0, m = slots1.length, n = slots2.length;
        while (left < m && right < n) {
            int[] A = slots1[left];
            int[] B = slots2[right];

            if (Math.min(A[1], B[1]) - Math.max(A[0], B[0]) >= duration)
                return Arrays.asList(Math.max(A[0], B[0]), Math.max(A[0], B[0]) + duration);

            if (A[1] < B[1])
                left++;
            else
                right++;
        }

        return new ArrayList<>();
    }
}