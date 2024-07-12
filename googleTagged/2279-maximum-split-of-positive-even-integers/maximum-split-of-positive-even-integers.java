class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1)
            return new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        solve(2, finalSum, ans, new ArrayList<>());
        return ans;
    }

    public void solve(long cur, long sum, List<Long> ans, List<Long> temp) {
        if (sum == 0) {
            ans.addAll(temp);
            return;
        }
        if (cur > sum)
            return;
        if (ans.size() == 0) {
            temp.add(cur);
            solve(cur + 2, sum - cur, ans, temp);
            temp.remove(temp.size() - 1);
            solve(cur + 2, sum, ans, temp);
        }
    }
}