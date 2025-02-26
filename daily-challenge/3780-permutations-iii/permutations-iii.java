class Solution {
    public int[][] permute(int n) {
        int picked[] = new int[n + 1];
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        solve(answer, picked, new ArrayList<>(), 2);
        int ans[][] = new int[answer.size()][n];
        int idx = 0;
        for (ArrayList<Integer> temp : answer) {
            int arr[] = new int[n];
            int j = 0;
            for (int i : temp) {
                arr[j++] = i;
            }
            ans[idx++] = arr;
        }

        return ans;
    }

    private void solve(ArrayList<ArrayList<Integer>> answer, int picked[], ArrayList<Integer> temp, int prev) {
        if (temp.size() == picked.length - 1) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 1; i <= picked.length - 1; i++) {
            if (picked[i] == 1)
                continue;
            if (prev == 2) {
                picked[i] = 1;
                temp.add(i);
                solve(answer, picked, temp, i % 2);
                temp.remove(temp.size() - 1);
                picked[i] = 0;
            } else if (prev == 1 && i % 2 == 0) {
                picked[i] = 1;
                temp.add(i);
                solve(answer, picked, temp, i % 2);
                temp.remove(temp.size() - 1);
                picked[i] = 0;
            } else if (prev == 0 && i % 2 == 1) {
                picked[i] = 1;
                temp.add(i);
                solve(answer, picked, temp, i % 2);
                temp.remove(temp.size() - 1);
                picked[i] = 0;
            }
        }
    }
}