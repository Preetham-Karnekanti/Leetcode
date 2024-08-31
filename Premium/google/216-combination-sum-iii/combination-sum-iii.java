class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }

    public void solve(int target, int k, List<List<Integer>> ans, ArrayList<Integer> temp, int cur) {
        if (k == 0) {
            if (target == 0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if (cur > 9)
            return;
        if (cur <= target) {
            temp.add(cur);
            solve(target - cur, k - 1, ans, temp, cur + 1);
            temp.remove(temp.size() - 1);
        }
        solve(target, k, ans, temp, cur + 1);
    }
}