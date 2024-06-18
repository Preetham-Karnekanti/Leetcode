class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Pair tasks[] = new Pair[n];
        for (int i = 0; i < n; i++)
            tasks[i] = new Pair(difficulty[i], profit[i]);
        Arrays.sort(tasks, (a, b) -> a.difficulty - b.difficulty);
        for (int i = 1; i < n; i++) {
            tasks[i].profit = Math.max(tasks[i].profit, tasks[i - 1].profit);
        }
        int total = 0;
        for (int i = 0; i < worker.length; i++) {
            total += binarySearch(worker[i], tasks);
        }
        return total;
    }

    public int binarySearch(int difficulty, Pair tasks[]) {
        int low = 0;
        int high = tasks.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (tasks[mid].difficulty <= difficulty) {
                low = mid + 1;
                ans = Math.max(ans, tasks[mid].profit);
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

class Pair {
    int difficulty;
    int profit;

    Pair(int d, int p) {
        this.difficulty = d;
        this.profit = p;
    }
}
