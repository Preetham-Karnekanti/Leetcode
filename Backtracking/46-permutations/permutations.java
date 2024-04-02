class Solution {
    HashSet<Integer> hs;

    public List<List<Integer>> permute(int[] input) {
        hs = new HashSet<>();
        List<List<Integer>> al = new ArrayList<>();
        solve(input, 0, al, new ArrayList<>());
        return al;
    }

    public void solve(int[] input, int idx, List<List<Integer>> al, List<Integer> temp) {
        if (temp.size() == input.length) {
            al.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!hs.contains(input[i])) {
                hs.add(input[i]);
                temp.add(input[i]);
                solve(input, i + 1, al, temp);
                temp.remove(temp.size() - 1);
                hs.remove(input[i]);
            }
        }
    }

    public void swap(int i, int j, int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}