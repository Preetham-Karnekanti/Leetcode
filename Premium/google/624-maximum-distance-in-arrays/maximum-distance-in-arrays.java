class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        for (int i = 1; i < arrays.size(); i++) {
            int min1 = arrays.get(i).get(0);
            int max1 = arrays.get(i).get(arrays.get(i).size() - 1);
            res = Math.max(res, Math.max(Math.abs(min - max1), Math.abs(max - min1)));
            min = Math.min(min1, min);
            max = Math.max(max1, max);
        }
        return res;
    }
}