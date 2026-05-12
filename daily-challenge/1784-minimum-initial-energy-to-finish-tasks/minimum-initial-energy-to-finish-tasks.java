class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int low = 0;
        int high = (int) 1e9;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(tasks, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean check(int[][] tasks, int max) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i][1] > max)
                return false;
            max -= tasks[i][0];
        }
        return true;
    }
}