class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int currentEmp[] = new int[n];
        return helper(requests, currentEmp, 0);
    }

    public int helper(int[][] requests, int currentEmp[], int idx) {
        if (idx == requests.length) {
            for (int i : currentEmp) {
                if (i != 0)
                    return (int) -105;
            }
            return 0;
        }
        int skip = helper(requests, currentEmp, idx + 1);
        int from = requests[idx][0];
        int to = requests[idx][1];
        currentEmp[from]--;
        currentEmp[to]++;
        int take = 1 + helper(requests, currentEmp, idx + 1);
        currentEmp[from]++;
        currentEmp[to]--;
        return Math.max(take, skip);
    }
}