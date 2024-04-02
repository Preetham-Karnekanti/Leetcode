class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                List<Integer> temp = List.of(arr[i], arr[i + 1]);
                al.add(temp);
            }
        }
        return al;
    }
}