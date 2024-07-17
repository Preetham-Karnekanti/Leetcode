class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        hm.put(x, new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                hm.get(x).add(i);
            }
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int pos = queries[i];
            if (pos > hm.get(x).size())
                ans[i] = -1;
            else
                ans[i] = hm.get(x).get(pos - 1);
        }
        return ans;
    }
}