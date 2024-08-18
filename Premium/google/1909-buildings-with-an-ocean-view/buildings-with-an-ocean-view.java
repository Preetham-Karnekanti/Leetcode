class Solution {
    public int[] findBuildings(int[] heights) {
        int max = -1;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                al.add(i);
                max = heights[i];
            }
        }
        int ans[] = new int[al.size()];
        int n = al.size() - 1;
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(n - i);
        }
        return ans;
    }
}