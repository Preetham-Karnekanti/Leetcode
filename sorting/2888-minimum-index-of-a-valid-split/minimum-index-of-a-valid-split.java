class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                dominant = nums.get(i);
            } else if (nums.get(i) == dominant) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant) {
                maxCount += 1;
            }
        }
        if (maxCount * 2 <= n)
            return -1;
        count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) {
                count++;
                maxCount--;
            }
            if (count * 2 > (i + 1) && maxCount * 2 > (n - i - 1))
                return i;
        }
        return -1;
    }
}