class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                al.add(i);
            }
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int pos = queries[i];
            if (pos > al.size())
                ans[i] = -1;
            else
                ans[i] = al.get(pos - 1);
        }
        return ans;
    }
}