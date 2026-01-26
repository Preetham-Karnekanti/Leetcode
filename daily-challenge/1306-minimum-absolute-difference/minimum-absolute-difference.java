class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        ArrayList<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (minDiff > diff) {
                answer.clear();
                minDiff = diff;
                answer.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (minDiff == diff) {
                answer.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return answer;
    }
}