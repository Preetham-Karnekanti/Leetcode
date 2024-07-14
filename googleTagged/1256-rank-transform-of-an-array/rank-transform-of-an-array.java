class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int rank = 1;
        int n = arr.length;
        int copy[] = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(copy[i])) {
                hm.put(copy[i], rank++);
            }
        }
        for (int i = 0; i < n; i++) {
            copy[i] = hm.get(arr[i]);
        }
        return copy;
    }
}